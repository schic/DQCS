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
package org.datacleaner.api;

import javax.inject.Named;

/**
 * Interface for {@link Component}s that transform data before analysis.
 * {@link Component}的接口，可在分析之前转换数据。
 *
 * See {@link Component} for general information about all components. Like all
 * components, {@link Analyzer} require a {@link Named} annotation in order to
 * be discovered.
 * 有关所有组件的一般信息，请参见{@link Component}。
 * 像所有组件一样，{@link Analyzer}需要一个{@link Named}批注才能被发现。
 *
 * A {@link Transformer} will process incoming rows and produce new fields which
 * are appended onto the existing rows. The {@link #transform(InputRow)} method
 * will be invoked on the {@link Transformer} for each row in a data stream.
 * {@link Transformer}将处理传入的行并产生新字段，这些新字段将附加到现有行上。
 * 对于数据流中的每一行，将在{@link Transformer}上调用{@link #transform（InputRow）}方法。
 *
 * While the above description covers most common usage of the transformer
 * interface there are a few ways to build even more advanced transformations.
 * 尽管上面的描述涵盖了转换器接口的最常用用法，但是有几种方法可以构建更高级的转换。
 *
 * Transformers can inject an {@link OutputRowCollector} in order to output
 * multiple records. The transform method should in such a case return null.
 * This also allows a {@link Transformer} to completely <i>swallow</i> a record,
 * not producing any output row for it, mean that it will not travel further in
 * the data stream. In many cases that's not a good thing (you might rather want
 * to build a {@link Filter} then) but it is possible.
 * 转换器可以注入{@link OutputRowCollector}以便输出多条记录。
 * 在这种情况下，transform方法应返回null。这还允许{@link Transformer}完全吞下一条记录，
 * 不为其产生任何输出行，这意味着它不会在数据流中进一步传播。
 * 在许多情况下，这不是一件好事（您可能希望构建一个{@link Filter}），但是有可能。
 *
 * @see OutputRowCollector
 * @see OutputColumns
 *
 * @since 4.0
 */
public interface Transformer extends Component {

    /**
     * Gets the output columns (given the current configuration) of this
     * transformer.
     *
     * @return an object with the information needed to create the output
     *         columns
     */
    OutputColumns getOutputColumns();

    /**
     * Transforms a row of input values to the corresponding transformed values
     *
     * @param inputRow
     * @return an array of transformed values.
     */
    Object[] transform(InputRow inputRow);
}
