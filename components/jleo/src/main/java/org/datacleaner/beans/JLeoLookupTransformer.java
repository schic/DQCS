package org.datacleaner.beans;

import com.google.common.cache.Cache;
import org.apache.metamodel.data.DataSet;
import org.apache.metamodel.query.CompiledQuery;
import org.apache.metamodel.query.OperatorType;
import org.apache.metamodel.query.Query;
import org.apache.metamodel.query.QueryParameter;
import org.apache.metamodel.schema.Column;
import org.apache.metamodel.schema.Table;
import org.apache.metamodel.util.HasName;
import org.datacleaner.api.*;
import org.datacleaner.components.categories.LeoTransCategory;
import org.datacleaner.connection.Datastore;
import org.datacleaner.connection.DatastoreConnection;
import org.datacleaner.result.CategorizationResult;
import org.datacleaner.storage.DummyRowAnnotationFactory;
import org.datacleaner.storage.RowAnnotation;
import org.datacleaner.storage.RowAnnotationFactory;
import org.datacleaner.util.CollectionUtils2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.Timestamp;
import java.util.*;

/**
 * @Description 统计主表与附表关联性数据情况转换器.可通过主附表相同的一个或多个字段全量筛选或部分筛选出具体数据.
 * @Author Leo
 * @Date 2021/3/26
 **/
@Named("主附表数据关联性")
@Description("寻找主表与附表关联性数据转换器.可通过主附表相同的一个或多个字段全量筛选或部分筛选出具体数据.")
@Concurrent(true)
@Categorized(LeoTransCategory.class)
public class JLeoLookupTransformer implements Transformer, HasLabelAdvice, HasAnalyzerResult<CategorizationResult> {

    public enum JoinSemantic implements HasName {
        @Alias("LEFT")
        LEFT_JOIN_MAX_ONE("Left join (max 1 record)"),

        @Alias("INNER")
        INNER_JOIN("Inner join"),

        @Alias("INNER_MIN_ONE")
        LEFT_JOIN("Left join");

        private final String _name;

        JoinSemantic(final String name) {
            _name = name;
        }

        @Override
        public String getName() {
            return _name;
        }

        public boolean isCacheable() {
            return this == LEFT_JOIN_MAX_ONE;
        }
    }
    private static final Logger logger = LoggerFactory.getLogger(JLeoLookupTransformer.class);
    private static final String PROPERTY_NAME_DATASTORE = "Datastore";
    private static final String PROPERTY_NAME_SCHEMA_NAME = "Schema name";
    private static final String PROPERTY_NAME_TABLE_NAME = "Table name";
    private final Cache<List<Object>, Object[]> cache = CollectionUtils2.createCache(10000, 5 * 60);
    @Inject
    @Configured(value = PROPERTY_NAME_DATASTORE)
    Datastore datastore;
    @Inject
    @Configured(value = "主表字段",required = false)
    InputColumn<?>[] conditionValues;//选中主表的字段
    @Inject
    @Configured(value = "附表字段",required = false)
    @ColumnProperty
    @MappedProperty(PROPERTY_NAME_TABLE_NAME)
    String[] conditionColumns ;//选中附表的字段
    @Inject
    @Configured("输出列")
    @Description("输出列和输入列只显示在预览数据中")
    @ColumnProperty
    @MappedProperty(PROPERTY_NAME_TABLE_NAME)
    String[] outputColumns ;//outputColumn属性中选中的字段可能是多个字段
    @Inject
    @Configured("附表日期字段")
    @Description("从附表中勾选一个时间字段以便筛选附表时间范围内的数据")
    @ColumnProperty
    @MappedProperty(PROPERTY_NAME_TABLE_NAME)
    String[] dateColumn ;
    @Inject
    @Configured(value = PROPERTY_NAME_SCHEMA_NAME)
    @Alias("Schema")
    @SchemaProperty
    @MappedProperty(PROPERTY_NAME_DATASTORE)
    String schemaName;
    @Inject
    @Configured(value = PROPERTY_NAME_TABLE_NAME)
    @Alias("附表")
    @TableProperty
    @MappedProperty(PROPERTY_NAME_SCHEMA_NAME)
    String tableName;
    @Inject
    @Configured("缓存查找")
    @Description("使用客户端缓存以避免使用相同的输入多次查找。")
    boolean cacheLookups = true;
    @Inject
    @Configured("SQL语义")
    @Description("与SQL连接相比，哪种语义应用于查找。")
    JLeoLookupTransformer.JoinSemantic joinSemantic = JLeoLookupTransformer.JoinSemantic.LEFT_JOIN_MAX_ONE;
    @Inject
    @Configured("附表日期范围")
    @Description("根据附表勾选的时间字段确定想要筛选到的时间范围。如果不选择时间段，将全量查询")
    String dateRangeString;
    @Inject
    @Provided
    OutputRowCollector outputRowCollector;
    @Inject
    @Provided
    RowAnnotationFactory annotationFactory;
    @Inject
    @Provided
    RowAnnotation tableATotal;
    @Inject
    @Provided
    RowAnnotation tableBTotal;
    @Inject
    @Provided
    RowAnnotation matchesTotal;
    @Inject
    @Provided
    RowAnnotation missesTotal;
    @Inject
    @Provided
    RowAnnotation cachedTotal;

    private Column[] queryOutputColumns;
    private Column[] queryConditionColumns;
    private Column[] queryDateColumns;
    private DatastoreConnection datastoreConnection;
    private CompiledQuery lookUpQuery;
    private CompiledQuery dataTotalQuery;

    public JLeoLookupTransformer() {
    }
    public JLeoLookupTransformer(final Datastore datastore, final String schemaName, final String tableName,
                                 final String[] conditionColumns, final InputColumn<?>[] conditionValues, final String[] outputColumns,
                                 final boolean cacheLookups, final String[] dateColumn, final String dateRangeString) {
        this.datastore = datastore;
        this.schemaName = schemaName;
        this.tableName = tableName;
        this.conditionColumns = conditionColumns;
        this.conditionValues = conditionValues;
        this.cacheLookups = cacheLookups;
        this.outputColumns = outputColumns;
        this.joinSemantic = JLeoLookupTransformer.JoinSemantic.LEFT_JOIN_MAX_ONE;
        this.dateColumn = dateColumn;
        this.dateRangeString = dateRangeString;
        annotationFactory = new DummyRowAnnotationFactory();
        tableATotal = annotationFactory.createAnnotation();
        tableBTotal = annotationFactory.createAnnotation();
        matchesTotal = annotationFactory.createAnnotation();
        missesTotal = annotationFactory.createAnnotation();
        cachedTotal = annotationFactory.createAnnotation();
    }

    /**
     * 为组件构建临时名字  如 Lookup: test_user
     * @return
     */
    @Override
    public String getSuggestedLabel() {
        if (tableName == null) {
            return null;
        }
        return "Lookup: " + tableName;
    }

    @Validate
    public void validate() {
        if (isCarthesianProductMode()) {
            return;
        }
        final Column[] queryConditionColumnss = getQueryConditionColumns();
        final List<String> columnsNotFound = new ArrayList<>();
        for (int i = 0; i < queryConditionColumnss.length; i++) {
            if (queryConditionColumnss[i] == null) {
                columnsNotFound.add(conditionColumns[i]);
            }
        }
        if (!columnsNotFound.isEmpty()) {
            throw new IllegalArgumentException("无法找到该列Could not find column(s): " + columnsNotFound);
        }
    }

    /**
     * 初始化
     */
    @Initialize
    public void init() {
        datastoreConnection = datastore.openConnection();
        resetCachedColumns();
        cache.invalidateAll();
        compileLookupQuery();
    }

    private void resetCachedColumns() {
        queryOutputColumns = null;
        queryConditionColumns = null;
    }

    /**
     * 构造完整的查询语句对象CompiledQuery
     */
    private void compileLookupQuery() {
        try {
            final Column[] queryOutputColumnss = getQueryOutputColumns(false);
            final Column[] queryDateColumnss = getQueryDateColumns(false);
            final Column queryOutputColumn = queryOutputColumnss[0];
            final Column queryDateColumn = queryDateColumnss[0];
            final Table table = queryOutputColumn.getTable();

            Query queryTableB = new Query().from(table).select(queryOutputColumnss);
            Query queryTableBCount = new Query().from(table).selectCount();
            if (!isCarthesianProductMode()) {
                final Column[] queryConditionColumnss = getQueryConditionColumns();
                for (int i = 0; i < queryConditionColumnss.length; i++) {
                    queryTableB = queryTableB.where(queryConditionColumnss[i], OperatorType.EQUALS_TO, new QueryParameter());
                }
                if (!dateRangeString.isEmpty()){
                    queryTableB = queryTableB.where(queryDateColumn,OperatorType.GREATER_THAN_OR_EQUAL,new QueryParameter());
                    queryTableB = queryTableB.where(queryDateColumn, OperatorType.LESS_THAN,new QueryParameter());
                }
            }

            if (joinSemantic == JLeoLookupTransformer.JoinSemantic.LEFT_JOIN_MAX_ONE) {
                queryTableB = queryTableB.setMaxRows(1);
            }
            lookUpQuery = datastoreConnection.getDataContext().compileQuery(queryTableB);
            dataTotalQuery = datastoreConnection.getDataContext().compileQuery(queryTableBCount);
            DataSet dataSet = datastoreConnection.getDataContext().executeQuery(dataTotalQuery);
            while (dataSet.next()){
                Long aLong = (Long) dataSet.getRow().getValue(0);
                annotationFactory.annotate(null,aLong.intValue(),tableBTotal);
            }
        } catch (final RuntimeException e) {
            logger.error("Error occurred while compiling lookup query", e);
            throw e;
        }
    }

    /**
     *  将客户端勾选到的字段String[]对象 转换为Column[]对象
     * @param checkNames 是否检查/验证/调整这些列的名称
     * @return
     */
    private Column[] getQueryOutputColumns(final boolean checkNames) {
        if (queryOutputColumns == null) {
            try {
                queryOutputColumns = datastore.openConnection().getSchemaNavigator().convertToColumns(schemaName, tableName, outputColumns);
            } catch (Exception e) {
                logger.error("附表中查询输出列错误:", e);
            }
        } else if (checkNames) {
            if (!isQueryOutputColumnsUpdated()) {
                queryOutputColumns = null;
                return getQueryOutputColumns(false);
            }
        }
        return queryOutputColumns;
    }

    /**
     *  将客户端勾选到附表的日期字段String[]对象 转换为Column[]对象 其实只能勾选一个字段
     * @param checkNames 是否检查/验证/调整这些列的名称
     * @return
     */
    private Column[] getQueryDateColumns(final boolean checkNames) {
        if (queryDateColumns == null) {
            try (DatastoreConnection con = datastore.openConnection()) {
                queryDateColumns = con.getSchemaNavigator().convertToColumns(schemaName, tableName, dateColumn);
            }
        } else if (checkNames) {
            if (!isQueryDateColumnsUpdated()) {
                queryDateColumns = null;
                return getQueryDateColumns(false);
            }
        }
        return queryDateColumns;
    }

    /**
     *  将客户端勾选到附表附表对应到主表的字段，String[]对象 转换为Column[]对象 一个或多个字段
     * @return
     */
    private Column[] getQueryConditionColumns() {
        if (queryConditionColumns == null) {
            if (!isCarthesianProductMode()) {
                try (DatastoreConnection con = datastore.openConnection()) {
                    queryConditionColumns =
                            con.getSchemaNavigator().convertToColumns(schemaName, tableName, conditionColumns);
                }
            } else {
                queryConditionColumns = new Column[0];
            }
        }
        return queryConditionColumns;
    }

    /**
     *      检查当前（缓存的）输出列数组的有效性。
     * @return 如果当前列有效，则为true
     */
    private boolean isQueryOutputColumnsUpdated() {
        if (queryOutputColumns.length != outputColumns.length) {
            return false;
        }
        for (int i = 0; i < queryOutputColumns.length; i++) {
            final Column outputField= queryOutputColumns[i];
            final String expectedName = outputColumns[i];
            if (tableName != null && !tableName.equals(outputField.getTable().getName())) {
                return false;
            }
            if (!expectedName.equals(outputField.getName())) {
                return false;
            }
        }
        return true;
    }

    /**
     *      检查当前（缓存的）输出列数组的有效性。
     * @return 如果当前列有效，则为true
     */
    private boolean isQueryDateColumnsUpdated() {
        if (queryDateColumns.length != 1) {
            return false;
        }
        for (int i = 0; i < queryDateColumns.length; i++) {
            final String expectedName = outputColumns[i];
            final Column dateField= queryDateColumns[i];
            if (tableName != null && !tableName.equals(dateField.getTable().getName())) {
                return false;
            }
            if (!expectedName.equals(dateField.getName())) {
                return false;
            }
        }
        return true;
    }

    /**
     * 附表是否勾选了对应于主表的字段
     * @return
     */
    private boolean isCarthesianProductMode() {
        return (conditionColumns == null || conditionColumns.length == 0) && (conditionValues == null
                || conditionValues.length == 0);
    }

    /**
     * 实现Transformer必须实现的第一个核心方法
     * 构造数据输出列。但并不在结果显示上。在预览数据上。
     * 这里只是构建好了输出列   那一列而已  如 user_id(lookup)。也就是最下面的OutputColumns 栏
     * @return
     */
    @Override
    public OutputColumns getOutputColumns() {
        final Column[] queryOutputColumnss = getQueryOutputColumns(true);
        final Class<?>[] types = new Class[queryOutputColumnss.length];
        final String[] names = new String[queryOutputColumnss.length];
        for (int i = 0; i < queryOutputColumnss.length; i++) {
            final Column column = queryOutputColumnss[i];
            if (column == null) {
                throw new IllegalArgumentException("无法找到该字段Could not find column: " + outputColumns[i]);
            }
            names[i] = column.getName() + " (lookup)";
            types[i] = column.getType().getJavaEquivalentClass();
        }
        return new OutputColumns(names, types);
    }

    /**
     * 实现Transformer必须实现的第二个核心方法
     * 这也是主表数据链接输入的总入口。
     * 该方法被框架反复调用，一次只进来一条数据。
     * @param inputRow 输入的一行数据
     * @return
     */
    @Override
    public Object[] transform(InputRow inputRow) {
        final List<Object> queryInput;
        if (!isCarthesianProductMode()) {
            queryInput = new ArrayList<>(conditionValues.length);
            for (final InputColumn<?> inputColumn : conditionValues) {
                final Object value = inputRow.getValue(inputColumn);
                queryInput.add(value);
            }
        } else {
            queryInput = Collections.emptyList();
        }

        logger.info("基于条件值查找Looking up based on condition values: {}", queryInput);

        Object[] result;
        if (cacheLookups && (joinSemantic.isCacheable())) {
            result = cache.getIfPresent(queryInput);
            if (result == null) {
                result = performQuery(inputRow, queryInput);
                cache.put(queryInput, result);
            } else {
                if (logger.isDebugEnabled()) {
                    logger.debug("返回缓存的查找结果Returning cached lookup result: {}", Arrays.toString(result));
                }
                annotationFactory.annotate(inputRow, 1, cachedTotal);
            }
        } else {
            result = performQuery(inputRow, queryInput);
        }

        return result;
    }

    /**
     * 传入一行数据，及该行数据的某些字段的值list。将主表这个字段值分别代入query去附表里查询
     * @param row   一行数据
     * @param queryInput    该行数据中某些字段的值list
     * @return
     */
    private Object[] performQuery(final InputRow row, final List<Object> queryInput) {
        try {
            final Column[] queryConditionColumnss = getQueryConditionColumns();

            final Object[] parameterValues = new Object[queryConditionColumnss.length+2];
            for (int i = 0; i < queryConditionColumnss.length; i++) {
                parameterValues[i] = queryInput.get(i);
            }
            if (!dateRangeString.isEmpty()){
                int index = dateRangeString.lastIndexOf('|');
                parameterValues[queryConditionColumns.length] = Timestamp.valueOf(dateRangeString.substring(0,index-1));
                parameterValues[queryConditionColumns.length+1] = Timestamp.valueOf(dateRangeString.substring(index+1));
            }

            try (DataSet dataSet = datastoreConnection.getDataContext().executeQuery(lookUpQuery, parameterValues)) {
                return handleDataSet(row, dataSet);
            }
        } catch (final RuntimeException e) {
            logger.error("Error occurred while looking up based on conditions: " + queryInput, e);
            throw e;
        }
    }

    /**
     * 解析附表查询后的结果集
     * @param row   主表的一行数据
     * @param dataSet   附表查询后的结果集
     * @return
     */
    private Object[] handleDataSet(final InputRow row, final DataSet dataSet) {
        if (!dataSet.next()) {
            logger.info("主表的该行数据没有在附表找到关联数据Result of lookup: None!");
            annotationFactory.annotate(row, 1, missesTotal);
            annotationFactory.annotate(row, 1, tableATotal);

            switch (this.joinSemantic) {
                case LEFT_JOIN_MAX_ONE:
                case LEFT_JOIN:
                    return new Object[outputColumns.length];
                default:
                    return null;
            }
        }

        annotationFactory.annotate(row, 1, matchesTotal);
        annotationFactory.annotate(row, 1, tableATotal);

        do {
            final Object[] result = dataSet.getRow().getValues();
            if (logger.isInfoEnabled()) {
                logger.info("Result_of_lookup: " + Arrays.toString(result));
            }
            switch (joinSemantic) {
                case LEFT_JOIN_MAX_ONE:
                    return result;
                default:
                    outputRowCollector.putValues(result);
            }

        } while (dataSet.next());

        return new Object[0];
    }

    /**
     *  构造出job执行后最后的结果图表
     * @return
     */
    @Override
    public CategorizationResult getResult() {
        final Map<String, RowAnnotation> categories = new LinkedHashMap<>();
        categories.put("主表总数据量", tableATotal);
        categories.put("附表总数据量", tableBTotal);
        categories.put("主表匹配量", matchesTotal);
        categories.put("主表遗漏量", missesTotal);
        if (cacheLookups) {
            categories.put("缓存数据量", cachedTotal);
        }
        return new CategorizationResult(annotationFactory, categories);
    }

    @Close
    public void close() {
        if (lookUpQuery != null) {
            lookUpQuery.close();
            lookUpQuery = null;
        }
        if (dataTotalQuery != null) {
            dataTotalQuery.close();
            dataTotalQuery = null;
        }
        if (datastore != null) {
            datastoreConnection.close();
            datastoreConnection = null;
        }
        cache.invalidateAll();
        queryOutputColumns = null;
        queryConditionColumns = null;
    }
}
