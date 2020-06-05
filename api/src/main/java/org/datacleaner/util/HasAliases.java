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
package org.datacleaner.util;

import org.apache.metamodel.util.HasName;

/**
 * Represents any object (typically a {@link HasName} instance) which has
 * aliases also. Aliases are typically used either to provide fault tolerance or
 * to support renaming components or properties and retaining backwards
 * compatibility.
 * 表示也具有别名的任何对象（通常是{@link HasName}实例）。
 * 别名通常用于提供容错能力或以支持重命名组件或属性并保持向后兼容性。
 */
public interface HasAliases {

    /**
     * Gets alias names for this object
     *
     * @return
     */
    String[] getAliases();
}
