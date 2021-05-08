package org.datacleaner.extension.sendjmsmessage.ui;

import org.datacleaner.api.InputColumn;
import org.datacleaner.descriptors.ConfiguredPropertyDescriptor;
import org.datacleaner.job.builder.AnalyzerComponentBuilder;
import org.datacleaner.job.builder.ComponentBuilder;
import org.datacleaner.panels.AnalyzerComponentBuilderPanel;
import org.datacleaner.widgets.properties.MultipleMappedStringsPropertyWidget;
import org.datacleaner.widgets.properties.PropertyWidget;
import org.datacleaner.widgets.properties.PropertyWidgetFactory;

/**
 * Job panel class for Analyzer.
 *
 */
public class SendMessageToJMSQueueAnalyzerJobPanel extends AnalyzerComponentBuilderPanel {

    private static final long serialVersionUID = 1L;

    private final MultipleMappedStringsPropertyWidget _mappedWidget;
    private final ConfiguredPropertyDescriptor _inputColumnsProperty;
    private final ConfiguredPropertyDescriptor _mappedStringsProperty;

    /**
     * Constructor.
     * 
     * @param analyzerJobBuilder
     * @param propertyWidgetFactory
     */
    public SendMessageToJMSQueueAnalyzerJobPanel(AnalyzerComponentBuilder<?> analyzerJobBuilder,
            PropertyWidgetFactory propertyWidgetFactory) {
        super(analyzerJobBuilder, propertyWidgetFactory);

        _inputColumnsProperty = analyzerJobBuilder.getDescriptor().getConfiguredProperty("Values");
        _mappedStringsProperty = analyzerJobBuilder.getDescriptor().getConfiguredProperty("Fields");

        _mappedWidget = new MultipleMappedStringsPropertyWidget(analyzerJobBuilder, _inputColumnsProperty,
                _mappedStringsProperty) {
            @Override
            protected String getDefaultMappedString(InputColumn<?> inputColumn) {
                return inputColumn.getName();
            }
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected PropertyWidget<?> createPropertyWidget(ComponentBuilder componentBuilder,
            ConfiguredPropertyDescriptor propertyDescriptor) {
        if (propertyDescriptor == _inputColumnsProperty) {
            return _mappedWidget;
        } else if (propertyDescriptor == _mappedStringsProperty) {
            return _mappedWidget.getMappedStringsPropertyWidget();
        }
        return super.createPropertyWidget(componentBuilder, propertyDescriptor);
    }
}
