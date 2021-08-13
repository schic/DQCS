/**
 * DataCleaner (community edition)
 * Copyright (C) 2014 Free Software Foundation, Inc.
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
package org.datacleaner.desktop.api;

import org.datacleaner.api.Component;
import org.datacleaner.api.Filter;
import org.datacleaner.api.Transformer;
import org.datacleaner.descriptors.FilterDescriptor;
import org.datacleaner.descriptors.TransformerDescriptor;
import org.datacleaner.job.builder.AnalysisJobBuilder;

/**
 * Interface for {@link Component}s that are capable of placing itself as a
 * consumer (succeeding component) of a preceding {@link Transformer} or
 * {@link Filter}.
 * {@link Component}的接口，
 * 这些接口能够将自身放置为先前{@link Transformer}或{@link Filter}的使用者（后继组件）。
 */
public interface PrecedingComponentConsumer extends Component {

    /**
     * Subclasses should implement this method with any configuration logic when
     * it is configured with a preceding {@link Transformer}.
     *
     * @param analysisJobBuilder
     *            the {@link AnalysisJobBuilder} being used to build this
     *            component
     * @param descriptor
     *            the descriptor of the {@link Transformer} that succeeds this
     *            component
     */
    void configureForTransformedData(AnalysisJobBuilder analysisJobBuilder, TransformerDescriptor<?> descriptor);

    /**
     * Subclasses should implement this method with any configuration logic when
     * it is configured with a preceding {@link Filter}.
     *
     * @param analysisJobBuilder
     *            the {@link AnalysisJobBuilder} being used to build this
     *            component
     * @param descriptor
     *            the descriptor of the {@link Filter} that succeeds this
     *            component
     * @param categoryName
     *            the outcome category of the filter that succeeds this
     *            component
     */
    void configureForFilterOutcome(AnalysisJobBuilder analysisJobBuilder, FilterDescriptor<?, ?> descriptor,
            String categoryName);
}
