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
package org.datacleaner.panels.completeness;

import javax.inject.Inject;

import org.datacleaner.api.Renderer;
import org.datacleaner.api.RendererBean;
import org.datacleaner.api.RendererPrecedence;
import org.datacleaner.beans.CompletenessAnalyzer;
import org.datacleaner.guice.DCModule;
import org.datacleaner.job.builder.AnalysisJobBuilder;
import org.datacleaner.job.builder.AnalyzerJobBuilder;
import org.datacleaner.panels.AnalyzerJobBuilderPresenter;
import org.datacleaner.panels.ComponentJobBuilderRenderingFormat;
import org.datacleaner.widgets.properties.PropertyWidgetFactory;

/**
 * Specialized {@link Renderer} for a {@link AnalysisJobBuilder} for
 * {@link CompletenessAnalyzer}.
 */
@RendererBean(ComponentJobBuilderRenderingFormat.class)
public class CompletenessAnalyzerJobBuilderPresenterRenderer implements
        Renderer<AnalyzerJobBuilder<CompletenessAnalyzer>, AnalyzerJobBuilderPresenter> {

    @Inject
    DCModule dcModule;

    @Override
    public RendererPrecedence getPrecedence(AnalyzerJobBuilder<CompletenessAnalyzer> ajb) {
        if (ajb.getDescriptor().getComponentClass() == CompletenessAnalyzer.class) {
            return RendererPrecedence.HIGH;
        }
        return RendererPrecedence.NOT_CAPABLE;
    }

    @Override
    public AnalyzerJobBuilderPresenter render(AnalyzerJobBuilder<CompletenessAnalyzer> ajb) {
        final PropertyWidgetFactory propertyWidgetFactory = dcModule.createChildInjectorForComponent(ajb).getInstance(PropertyWidgetFactory.class);

        return new CompletenessAnalyzerJobBuilderPresenter(ajb, propertyWidgetFactory);
    }

}