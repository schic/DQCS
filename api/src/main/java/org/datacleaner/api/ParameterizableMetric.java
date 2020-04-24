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

import java.util.Collection;

/**
 * Represents a parameterizable metric definition. With this instance you allow
 * metrics to provide (potentially dynamic) metadata about the metric to hint
 * how it should be properly parameterized.
 * 表示可参数化的指标定义。在此实例中，您允许指标提供（可能是动态的）有关该指标的元数据，
 * 以提示应该如何正确设置参数。
 *
 * Use the {@link #getValue(String)} with an actual parameter to retrieve the
 * metric value.
 * 将{@link #getValue（String）}与实际参数一起使用以获取度量值。
 *
 * @see Metric
 */
public interface ParameterizableMetric {

    Collection<String> getParameterSuggestions();

    Number getValue(String parameter);
}
