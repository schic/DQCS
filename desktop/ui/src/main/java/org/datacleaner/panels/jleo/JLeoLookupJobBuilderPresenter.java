package org.datacleaner.panels.jleo;

import org.datacleaner.api.InputColumn;
import org.datacleaner.beans.JLeoLookupTransformer;
import org.datacleaner.bootstrap.WindowContext;
import org.datacleaner.configuration.DataCleanerConfiguration;
import org.datacleaner.connection.Datastore;
import org.datacleaner.descriptors.ConfiguredPropertyDescriptor;
import org.datacleaner.descriptors.TransformerDescriptor;
import org.datacleaner.guice.DCModule;
import org.datacleaner.job.builder.ComponentBuilder;
import org.datacleaner.job.builder.TransformerComponentBuilder;
import org.datacleaner.panels.ConfiguredPropertyTaskPane;
import org.datacleaner.panels.TransformerComponentBuilderPanel;
import org.datacleaner.util.IconUtils;
import org.datacleaner.widgets.properties.*;

import java.util.*;

/**
 * @Description 该类是自定义渲染器
 * @Author LeoDY
 * @Date 2021/3/26
 **/
public class JLeoLookupJobBuilderPresenter extends TransformerComponentBuilderPanel {

    private static final long serialVersionUID = 1L;

    private final Map<ConfiguredPropertyDescriptor, PropertyWidget<?>> _overriddenPropertyWidgets;

    private final ConfiguredPropertyDescriptor _schemaNameProperty;
    private final ConfiguredPropertyDescriptor _tableNameProperty;
    private final ConfiguredPropertyDescriptor _datastoreProperty;
    private final ConfiguredPropertyDescriptor _inputColumnArrayProperty;
    private final ConfiguredPropertyDescriptor _inputDateColumnProperty;
    private final ConfiguredPropertyDescriptor _columnNameArrayProperty;
    private final ConfiguredPropertyDescriptor _outputColumnsProperty;
    //private final ConfiguredPropertyDescriptor _cacheLookupsProperty;
    private final ConfiguredPropertyDescriptor _joinSemanticProperty;
    //private final ConfiguredPropertyDescriptor _dateColumnProperty;
    //private final ConfiguredPropertyDescriptor _dateRangeProperty;
    private final ConfiguredPropertyDescriptor _matchTimeRangeProperty;


    public JLeoLookupJobBuilderPresenter(
            final TransformerComponentBuilder<JLeoLookupTransformer> transformerJobBuilder,
            final WindowContext windowContext, final PropertyWidgetFactory propertyWidgetFactory,
            final DataCleanerConfiguration configuration, final DCModule dcModule) {
        super(transformerJobBuilder, windowContext, propertyWidgetFactory, configuration);
        _overriddenPropertyWidgets = new HashMap<>();
        //这里的descriptor 已经拿到组件中所有成员 变量 配置属性 提供属性 初始化方法 结束方法 。。。。
        final TransformerDescriptor<?> descriptor = transformerJobBuilder.getDescriptor();
        assert descriptor.getComponentClass() == JLeoLookupTransformer.class;

        _datastoreProperty = descriptor.getConfiguredProperty("Datastore");//这些名字是在组建中取好的 如果没有 就是变量名拆分
        _schemaNameProperty = descriptor.getConfiguredProperty("Schema name");
        _tableNameProperty = descriptor.getConfiguredProperty("Table name");
        _inputColumnArrayProperty = descriptor.getConfiguredProperty("主表字段");
        _columnNameArrayProperty = descriptor.getConfiguredProperty("附表字段");
        _outputColumnsProperty = descriptor.getConfiguredProperty("输出列");
        //_cacheLookupsProperty = descriptor.getConfiguredProperty("缓存查找");
        _joinSemanticProperty = descriptor.getConfiguredProperty("SQL语义");
        //_dateColumnProperty = descriptor.getConfiguredProperty("附表日期字段");
        //_dateRangeProperty = descriptor.getConfiguredProperty("附表日期范围");
        _inputDateColumnProperty = descriptor.getConfiguredProperty("主表日期字段");
        _matchTimeRangeProperty = descriptor.getConfiguredProperty("主表时间区间");

        // the Datastore property      assert断言关键字；
        assert _datastoreProperty != null;
        assert _datastoreProperty.getType() == Datastore.class;
        final SingleDatastorePropertyWidget datastorePropertyWidget =
                new SingleDatastorePropertyWidget(transformerJobBuilder, _datastoreProperty,
                        configuration.getDatastoreCatalog(), dcModule);
        _overriddenPropertyWidgets.put(_datastoreProperty, datastorePropertyWidget);//生成一个datastore组合框放进去

        // The schema name (String) property
        final SchemaNamePropertyWidget schemaNamePropertyWidget =
                new SchemaNamePropertyWidget(transformerJobBuilder, _schemaNameProperty);
        _overriddenPropertyWidgets.put(_schemaNameProperty, schemaNamePropertyWidget);//生成一个schema专用的下拉框

        // The table name (String) property
        final SingleTableNamePropertyWidget tableNamePropertyWidget =
                new SingleTableNamePropertyWidget(transformerJobBuilder, _tableNameProperty, windowContext);
        _overriddenPropertyWidgets.put(_tableNameProperty, tableNamePropertyWidget);//生成一个table专用的下拉列表

        //the output columns (String[]) property
        final JLeoLookupOutputColumnsPropertyWidget outputColumnsPropertyWidget =
                new JLeoLookupOutputColumnsPropertyWidget(transformerJobBuilder, _outputColumnsProperty);
        _overriddenPropertyWidgets.put(_outputColumnsProperty, outputColumnsPropertyWidget);

        assert _inputDateColumnProperty != null;
        assert _inputDateColumnProperty.getType() == InputColumn[].class;
        final JLeoInputDatePropertyWidget  inputDatePropertyWidget =
                new JLeoInputDatePropertyWidget(transformerJobBuilder, _inputDateColumnProperty);
        _overriddenPropertyWidgets.put(_inputDateColumnProperty, inputDatePropertyWidget);

        //final JLeoLookupDateColumnsPropertyWidget dateColumnPropertyWidget =
        //        new JLeoLookupDateColumnsPropertyWidget(transformerJobBuilder, _dateColumnProperty);
        //_overriddenPropertyWidgets.put(_dateColumnProperty, dateColumnPropertyWidget);
        //dateColumnPropertyWidget.addVisitableListener(item -> {//这里选中表触发事件，item已包含 数据表信息；
        //});

        // the InputColumn<?>[] property
        assert _inputColumnArrayProperty != null;
        assert _inputColumnArrayProperty.getType() == InputColumn[].class;
        final MultipleMappedColumnsPropertyWidget inputColumnsPropertyWidget =
                new MultipleMappedColumnsPropertyWidget(transformerJobBuilder, _inputColumnArrayProperty,
                        _columnNameArrayProperty);
        _overriddenPropertyWidgets.put(_inputColumnArrayProperty, inputColumnsPropertyWidget);

        // the String[] property
        assert _columnNameArrayProperty != null;
        assert _columnNameArrayProperty.getType() == String[].class;
        _overriddenPropertyWidgets
                .put(_columnNameArrayProperty, inputColumnsPropertyWidget.getMappedColumnNamesPropertyWidget());

        // chain combo boxes 组合框链  这里就是组合一下，最前面是datastore的框，连接schema的框再连接table的框
        datastorePropertyWidget.connectToSchemaNamePropertyWidget(schemaNamePropertyWidget);
        schemaNamePropertyWidget.connectToTableNamePropertyWidget(tableNamePropertyWidget);

        tableNamePropertyWidget.addComboListener(item -> {//这里选中表触发事件，item已包含 数据表信息；
            //  选择附表时更新列组合框
            inputColumnsPropertyWidget.setTable(item);
            outputColumnsPropertyWidget.setTable(item);
            //dateColumnPropertyWidget.setTable(item);
        });

        // initialize
        schemaNamePropertyWidget.setDatastore(datastorePropertyWidget.getValue());
        tableNamePropertyWidget.setSchema(datastorePropertyWidget.getValue(), schemaNamePropertyWidget.getSchema());
        outputColumnsPropertyWidget.setTable(tableNamePropertyWidget.getTable());
        //dateColumnPropertyWidget.setTable(tableNamePropertyWidget.getTable());
        inputColumnsPropertyWidget.setTable(tableNamePropertyWidget.getTable());
    }

    @Override
    protected List<ConfiguredPropertyTaskPane> createPropertyTaskPanes() {
        final List<ConfiguredPropertyTaskPane> propertyTaskPanes = new ArrayList<>();

        final ConfiguredPropertyTaskPane inputMappingTaskPane =
                new ConfiguredPropertyTaskPane("输入端映射", "images/model/column.png",
                        Arrays.asList(_datastoreProperty, _schemaNameProperty, _tableNameProperty,
                                _inputColumnArrayProperty, _columnNameArrayProperty));
        final ConfiguredPropertyTaskPane outputMappingTaskPane =
                new ConfiguredPropertyTaskPane("输出端映射", IconUtils.MENU_OPTIONS,
                        Arrays.asList(_outputColumnsProperty, _joinSemanticProperty, _inputDateColumnProperty,_matchTimeRangeProperty));

        propertyTaskPanes.add(inputMappingTaskPane);
        propertyTaskPanes.add(outputMappingTaskPane);

        return propertyTaskPanes;
    }

    @Override
    protected PropertyWidget<?> createPropertyWidget(final ComponentBuilder componentBuilder,
                                                     final ConfiguredPropertyDescriptor propertyDescriptor) {
        if (_overriddenPropertyWidgets.containsKey(propertyDescriptor)) {
            return _overriddenPropertyWidgets.get(propertyDescriptor);
        }
        return super.createPropertyWidget(componentBuilder, propertyDescriptor);
    }
}
