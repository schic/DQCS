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

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation used to mark a getter-method as a retrieval mechanism for
 * {@link AnalyzerResult} metrics.
 * 用于将getter-method标记为* {@link AnalyzerResult}度量的检索机制的注释。
 *
 * A metric is an exposed number value which can be used to get summary
 * statistics of a particular result. This mechanism is used to allow
 * applications to compare results over time, by comparing their metrics.
 * 指标是公开的数字值，可用于获取摘要特定结果的统计信息。
 * 该机制用于允许应用程序通过比较其指标来随时间比较结果。
 *
 * This annotation should be used for methods that conform to these
 * restrictions:
 * <ul>
 * <li>The return type must be a {@link Number} or a subtype of {@link Number},
 * including primitive/unboxed types. Alternatively it is possible to return an
 * {@link ParameterizableMetric} instance which allow the consumer to get more
 * metadata about the metrics parameter values.</li>
 * <li>The method can optionally have an {@link InputColumn} parameter, if the
 * metric contains different values for different analyzed columns.</li>
 * <li>The method can optionally have a String parameter, if the metric
 * furthermore takes a user-defined query parameter.</li>
 * <li>Except for the above mentioned exceptions, the method must not have any
 * parameters.</li>
 * </ul>
 * 此注释应用于符合以下限制的方法：
 *   返回类型必须是{@link Number}或{@link Number}的子类型，包括原始/未装箱的类型。
 * 或者，可以返回{@link ParameterizableMetric}实例，该实例使使用者可以获取有关metrics参数值的更多元数据。
 *   如果度量标准包含针对不同分析列的不同值，则该方法可以选择具有{@link InputColumn}参数。
 *   如果度量还采用了用户定义的查询参数，则该方法可以选择具有String参数。
 *   除了上述例外，该方法不得具有任何参数。
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
@Documented
@Inherited
public @interface Metric {

    /**
     * Defines the name of the metric. A metric name must be unique for any
     * particular {@link AnalyzerResult} class.
     *
     * @return the name of the metric.
     */
    String value();

    /**
     * Defines the display order of this metric, relative to other metrics.
     *
     * @return the order (if any) of this metric when sorting metrics of a
     *         result type. A low order will place the metric before higher
     *         order metric.
     */
    int order() default Integer.MAX_VALUE;

    /**
     * Defines if the string parameter of this metric (if any) supports IN and
     * NOT INT expressions.
     *
     * @return
     */
    boolean supportsInClause() default false;
}
