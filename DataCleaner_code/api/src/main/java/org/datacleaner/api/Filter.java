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
 * Interface for a {@link Component} that filters/categorizes rows.
 * {@link Component}的界面，用于对行进行过滤/分类。
 *
 * See {@link Component} for general information about all components. Like all
 * components, {@link Analyzer} require a {@link Named} annotation in order to
 * be discovered.
 * 有关所有组件的一般信息，请参见{@link Component}。像所有组件一样，{
 * @ link Analyzer}需要一个{@link Named}批注才能被发现。
 *
 * A {@link Filter} will process incoming rows and label them with a category. A
 * category is defined as a value in an enum. When a row is categorized, this
 * category can then be used to set up a requirement for succeeding row
 * processing.
 * {@link Filter}将处理传入的行并为它们添加类别。
 * 类别定义为枚举中的值。对行进行分类后，可以使用此类别为后续的行处理建立需求。
 *
 * A sub-interface of Filter exists, {@link QueryOptimizedFilter}, which allows
 * filter functionality to be pushed down to the query in certain circumstances
 * where it is desirable to do so. Also check out the {@link Optimizeable}
 * annotation which may be useful when applying {@link QueryOptimizedFilter}.
 * 存在Filter的子接口{@link QueryOptimizedFilter}，
 * 该子接口允许在某些情况下*过滤器功能可以推到查询中需要这样做的地方。
 * 另外，请检查出{@link Optimizeable} 注释，该注释在应用{@link QueryOptimizedFilter}时可能会有用
 *
 * @param <C>
 *            an enum type with the available categories
 *              具有可用类别的枚举类型
 * @since 4.0
 */
public interface Filter<C extends Enum<C>> extends Component {

    /**
     * Categorizes/filters a single row.
     *
     * @param inputRow
     *            the row to categorize.
     * @return an enum representing the category applied to the row.
     */
    C categorize(InputRow inputRow);
}
