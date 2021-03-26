package org.datacleaner.panels.jleo;

import org.datacleaner.api.Renderer;
import org.datacleaner.api.RendererBean;
import org.datacleaner.api.RendererPrecedence;
import org.datacleaner.beans.JLeoLookupTransformer;
import org.datacleaner.bootstrap.WindowContext;
import org.datacleaner.configuration.DataCleanerConfiguration;
import org.datacleaner.guice.DCModule;
import org.datacleaner.job.builder.TransformerComponentBuilder;
import org.datacleaner.panels.ComponentBuilderPresenterRenderingFormat;
import org.datacleaner.panels.TransformerComponentBuilderPresenter;
import org.datacleaner.widgets.properties.PropertyWidgetFactory;

import javax.inject.Inject;

/**
 * @Description
 * @Author LeoDY
 * @Date 2021/3/26
 **/
@RendererBean(ComponentBuilderPresenterRenderingFormat.class)
public class JLeoLookupJobBuilderPresenterRenderer implements Renderer<TransformerComponentBuilder<JLeoLookupTransformer>, TransformerComponentBuilderPresenter> {

    @Inject
    WindowContext windowContext;

    @Inject
    DataCleanerConfiguration configuration;

    @Inject
    DCModule dcModule;

    @Override
    public RendererPrecedence getPrecedence(final TransformerComponentBuilder<JLeoLookupTransformer> tjb) {
        if (tjb.getDescriptor().getComponentClass() == JLeoLookupTransformer.class) {
            return RendererPrecedence.HIGH;
        }
        return RendererPrecedence.NOT_CAPABLE;
    }

    @Override
    public TransformerComponentBuilderPresenter render(final TransformerComponentBuilder<JLeoLookupTransformer> tjb) {
        final PropertyWidgetFactory propertyWidgetFactory =
                dcModule.createChildInjectorForComponent(tjb).getInstance(PropertyWidgetFactory.class);

        return new JLeoLookupJobBuilderPresenter(tjb, windowContext, propertyWidgetFactory, configuration, dcModule);
    }

}
