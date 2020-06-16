package org.datacleaner.extension.sendjmsmessage.ui;

import javax.inject.Inject;

import org.datacleaner.api.Renderer;
import org.datacleaner.api.RendererBean;
import org.datacleaner.api.RendererPrecedence;
import org.datacleaner.extension.sendjmsmessage.SendMessageToJMSQueueAnalyzer;
import org.datacleaner.guice.DCModule;
import org.datacleaner.job.builder.AnalyzerComponentBuilder;
import org.datacleaner.panels.AnalyzerComponentBuilderPresenter;
import org.datacleaner.panels.ComponentBuilderPresenterRenderingFormat;
import org.datacleaner.widgets.properties.PropertyWidgetFactory;

/**
 * Swing renender for {@link SendMessageToJMSQueueAnalyzer}
 * 
 */
@RendererBean(ComponentBuilderPresenterRenderingFormat.class)
public class SendMessageToJMSQueueAnalyzerSwingRenderer implements
        Renderer<AnalyzerComponentBuilder<SendMessageToJMSQueueAnalyzer>, AnalyzerComponentBuilderPresenter> {

    @Inject
    DCModule dcModule;

    /**
     * {@inheritDoc}
     */
    @Override
    public RendererPrecedence getPrecedence(AnalyzerComponentBuilder<SendMessageToJMSQueueAnalyzer> ajb) {
        Class<SendMessageToJMSQueueAnalyzer> componentClass = ajb.getDescriptor().getComponentClass();
        if (componentClass == SendMessageToJMSQueueAnalyzer.class) {
            return RendererPrecedence.HIGH;
        }
        return RendererPrecedence.NOT_CAPABLE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AnalyzerComponentBuilderPresenter render(AnalyzerComponentBuilder<SendMessageToJMSQueueAnalyzer> ajb) {
        final PropertyWidgetFactory propertyWidgetFactory = dcModule.createChildInjectorForComponent(ajb).getInstance(
                PropertyWidgetFactory.class);
        return new SendMessageToJMSQueueAnalyzerJobPanel(ajb, propertyWidgetFactory);
    }

}
