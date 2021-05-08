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
 * Ananalyzer is a {@link Component} that recieves rows of data and produces an
 * {@link AnalyzerResult} from it.
 * Ananalyzer是一个{@link Component}，它接收数据行并从中产生一个{@link AnalyzerResult}。
 *
 * See {@link Component} for general information about all components. Like all
 * components, {@link Analyzer} require a {@link Named} annotation in order to
 * be discovered.
 * 有关所有组件的一般信息，请参见{@link Component}。
 * 像所有组件一样，{@ link Analyzer}需要一个{@link Named}批注才能被发现。
 *
 * The {@link #run(InputRow, int)} method will be invoked on the
 * {@link Analyzer} for each row in a data stream. The framework may choose to
 * optimize the number of operations in case multiple exactly identical rows
 * occur. In such case the {@link #run(InputRow, int)} may only be invoked once
 * but with a greater-than-1 second argument.
 * 对于数据流中的每一行，将在* {@link分析器}上调用{@link #run（InputRow，int）}方法。
 * 如果出现多个完全相同的行，框架可以选择优化操作数量。在这种情况下，
 * {@link #run(InputRow, int)}只能被调用一次，但是第二个参数大于1。
 *
 * Use of the {@link Named} annotation is required for the {@link Analyzer} to
 * by automatically discovered.
 * 要使{@link Analyzer}自动发现，必须使用{@link Named}批注。
 *
 * See {@link Component} for more details.
 * 有关更多详细信息，请参见{@link Component}。
 *
 * @param <R>
 *            the {@link AnalyzerResult} type of this analyzer.
 *
 * @since 4.0
 */
public interface Analyzer<R extends AnalyzerResult> extends Component, HasAnalyzerResult<R> {

    /**
     * Executes the analyzer for a single row.
     *
     * @param row
     *            the row to analyze
     * @param distinctCount
     *            the distinct count of the row.
     */
    void run(InputRow row, int distinctCount);

    /**
     * Gets the result of the analysis that the analyzer has conducted.
     *
     * @return an analyzer result object.
     */
    @Override
    R getResult();
}
