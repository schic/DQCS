/**
 * DataCleaner (community edition)
 * Copyright (C) 2014 Neopost - Customer Information Management
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package org.datacleaner.panels.tablelookup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.metamodel.schema.Table;
import org.datacleaner.api.InputColumn;
import org.datacleaner.components.tablelookup.TableLookupTransformer;
import org.datacleaner.configuration.AnalyzerBeansConfiguration;
import org.datacleaner.connection.Datastore;
import org.datacleaner.descriptors.ConfiguredPropertyDescriptor;
import org.datacleaner.descriptors.TransformerBeanDescriptor;
import org.datacleaner.job.builder.AbstractBeanJobBuilder;
import org.datacleaner.job.builder.TransformerJobBuilder;
import org.datacleaner.bootstrap.WindowContext;
import org.datacleaner.panels.ConfiguredPropertyTaskPane;
import org.datacleaner.panels.TransformerJobBuilderPanel;
import org.datacleaner.panels.TransformerJobBuilderPresenter;
import org.datacleaner.util.IconUtils;
import org.datacleaner.widgets.DCComboBox.Listener;
import org.datacleaner.widgets.properties.MultipleMappedColumnsPropertyWidget;
import org.datacleaner.widgets.properties.PropertyWidget;
import org.datacleaner.widgets.properties.PropertyWidgetFactory;
import org.datacleaner.widgets.properties.SchemaNamePropertyWidget;
import org.datacleaner.widgets.properties.SingleDatastorePropertyWidget;
import org.datacleaner.widgets.properties.SingleTableNamePropertyWidget;

/**
 * Specialized {@link TransformerJobBuilderPresenter} for the
 * {@link TableLookupTransformer}.
 * 
 * @author Kasper Sørensen
 */
class TableLookupJobBuilderPresenter extends TransformerJobBuilderPanel {

    private static final long serialVersionUID = 1L;

    private final Map<ConfiguredPropertyDescriptor, PropertyWidget<?>> _overriddenPropertyWidgets;

    private final ConfiguredPropertyDescriptor _schemaNameProperty;
    private final ConfiguredPropertyDescriptor _tableNameProperty;
    private final ConfiguredPropertyDescriptor _datastoreProperty;
    private final ConfiguredPropertyDescriptor _inputColumnArrayProperty;
    private final ConfiguredPropertyDescriptor _columnNameArrayProperty;
    private final ConfiguredPropertyDescriptor _outputColumnsProperty;
    private final ConfiguredPropertyDescriptor _cacheLookupsProperty;
    private final ConfiguredPropertyDescriptor _joinSemanticProperty;

    public TableLookupJobBuilderPresenter(TransformerJobBuilder<TableLookupTransformer> transformerJobBuilder,
            WindowContext windowContext, PropertyWidgetFactory propertyWidgetFactory,
            AnalyzerBeansConfiguration configuration) {
        super(transformerJobBuilder, windowContext, propertyWidgetFactory, configuration);
        _overriddenPropertyWidgets = new HashMap<ConfiguredPropertyDescriptor, PropertyWidget<?>>();

        final TransformerBeanDescriptor<?> descriptor = transformerJobBuilder.getDescriptor();
        assert descriptor.getComponentClass() == TableLookupTransformer.class;

        _datastoreProperty = descriptor.getConfiguredProperty("Datastore");
        _schemaNameProperty = descriptor.getConfiguredProperty("Schema name");
        _tableNameProperty = descriptor.getConfiguredProperty("Table name");
        _inputColumnArrayProperty = descriptor.getConfiguredProperty("Condition values");
        _columnNameArrayProperty = descriptor.getConfiguredProperty("Condition columns");
        _outputColumnsProperty = descriptor.getConfiguredProperty("Output columns");
        _cacheLookupsProperty = descriptor.getConfiguredProperty("Cache lookups");
        _joinSemanticProperty = descriptor.getConfiguredProperty("Join semantic");

        // the Datastore property
        assert _datastoreProperty != null;
        assert _datastoreProperty.getType() == Datastore.class;
        final SingleDatastorePropertyWidget datastorePropertyWidget = new SingleDatastorePropertyWidget(
                transformerJobBuilder, _datastoreProperty, configuration.getDatastoreCatalog());
        _overriddenPropertyWidgets.put(_datastoreProperty, datastorePropertyWidget);

        // The schema name (String) property
        final SchemaNamePropertyWidget schemaNamePropertyWidget = new SchemaNamePropertyWidget(transformerJobBuilder,
                _schemaNameProperty);
        _overriddenPropertyWidgets.put(_schemaNameProperty, schemaNamePropertyWidget);

        // The table name (String) property
        final SingleTableNamePropertyWidget tableNamePropertyWidget = new SingleTableNamePropertyWidget(transformerJobBuilder,
                _tableNameProperty);
        _overriddenPropertyWidgets.put(_tableNameProperty, tableNamePropertyWidget);

        // the output columns (String[]) property
        final TableLookupOutputColumnsPropertyWidget outputColumnsPropertyWidget = new TableLookupOutputColumnsPropertyWidget(
                transformerJobBuilder, _outputColumnsProperty);
        _overriddenPropertyWidgets.put(_outputColumnsProperty, outputColumnsPropertyWidget);

        // the InputColumn<?>[] property
        assert _inputColumnArrayProperty != null;
        assert _inputColumnArrayProperty.getType() == InputColumn[].class;
        final MultipleMappedColumnsPropertyWidget inputColumnsPropertyWidget = new MultipleMappedColumnsPropertyWidget(
                transformerJobBuilder, _inputColumnArrayProperty, _columnNameArrayProperty);
        _overriddenPropertyWidgets.put(_inputColumnArrayProperty, inputColumnsPropertyWidget);

        // the String[] property
        assert _columnNameArrayProperty != null;
        assert _columnNameArrayProperty.getType() == String[].class;
        _overriddenPropertyWidgets.put(_columnNameArrayProperty,
                inputColumnsPropertyWidget.getMappedColumnNamesPropertyWidget());

        // chain combo boxes
        datastorePropertyWidget.connectToSchemaNamePropertyWidget(schemaNamePropertyWidget);
        schemaNamePropertyWidget.connectToTableNamePropertyWidget(tableNamePropertyWidget);

        tableNamePropertyWidget.addComboListener(new Listener<Table>() {
            @Override
            public void onItemSelected(Table item) {
                // update the column combo boxes when the table is selected
                inputColumnsPropertyWidget.setTable(item);
                outputColumnsPropertyWidget.setTable(item);
            }
        });

        // initialize
        schemaNamePropertyWidget.setDatastore(datastorePropertyWidget.getValue());
        tableNamePropertyWidget.setSchema(schemaNamePropertyWidget.getSchema());
        outputColumnsPropertyWidget.setTable(tableNamePropertyWidget.getTable());
        inputColumnsPropertyWidget.setTable(tableNamePropertyWidget.getTable());
    }

    @Override
    protected List<ConfiguredPropertyTaskPane> createPropertyTaskPanes() {
        final List<ConfiguredPropertyTaskPane> propertyTaskPanes = new ArrayList<ConfiguredPropertyTaskPane>();

        final ConfiguredPropertyTaskPane inputMappingTaskPane = new ConfiguredPropertyTaskPane("Input mapping",
                "images/model/column.png", Arrays.asList(_datastoreProperty, _schemaNameProperty, _tableNameProperty,
                        _inputColumnArrayProperty, _columnNameArrayProperty));
        final ConfiguredPropertyTaskPane outputMappingTaskPane = new ConfiguredPropertyTaskPane("Output mapping",
                IconUtils.MENU_OPTIONS, Arrays.asList(_outputColumnsProperty, _joinSemanticProperty,
                        _cacheLookupsProperty));
        propertyTaskPanes.add(inputMappingTaskPane);
        propertyTaskPanes.add(outputMappingTaskPane);

        return propertyTaskPanes;
    }

    @Override
    protected PropertyWidget<?> createPropertyWidget(AbstractBeanJobBuilder<?, ?, ?> beanJobBuilder,
            ConfiguredPropertyDescriptor propertyDescriptor) {
        if (_overriddenPropertyWidgets.containsKey(propertyDescriptor)) {
            return _overriddenPropertyWidgets.get(propertyDescriptor);
        }
        return super.createPropertyWidget(beanJobBuilder, propertyDescriptor);
    }
}