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

import java.io.Serializable;

import org.apache.metamodel.util.HasName;

/**
 * Represents a "super category" of components. Where {@link ComponentCategory}
 * represents the groupings of related components, the super categorization is
 * used for representing broader categories of components such as
 * 代表组件的“超级类别”。其中{@link ComponentCategory}表示相关组件的分组，
 * 而超级分类用于表示更广泛的组件类别，例如
 */
public interface ComponentSuperCategory extends Serializable, HasName, Comparable<ComponentSuperCategory> {

    /**
     * Gets the name of the category. The name is often used as the primary
     * identifier of a category.
     *
     * @return a string name
     */
    @Override
    String getName();

    /**
     * Gets the description of the category.
     *
     * @return
     */
    String getDescription();

    /**
     * Gets an index for sorting of {@link ComponentSuperCategory} objects. Any
     * value is valid. The sequence of numbers will guide how a presentation of
     * categories will be sorted.
     *
     * @return
     */
    int getSortIndex();
}
