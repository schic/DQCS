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
package org.datacleaner.reference;

import java.io.Serializable;

import org.datacleaner.api.Close;
import org.datacleaner.api.Initialize;
import org.datacleaner.configuration.DataCleanerConfiguration;

/**
 * A dictionary represents a set of values grouped together with a label.
 * 字典代表与标签分组在一起的一组值。
 *
 * Examples of meaningful dictionaries:
 * <ul>
 * <li>Lastnames</li>
 * <li>Female given names</li>
 * <li>Product codes</li>
 * </ul>
 * 有意义的字典示例：
 * 姓氏
 * 女名
 * 产品代号
 *
 * Often times a dictionary will implement a caching mechanism to prevent having
 * to hold all values of the dictionary in memory.
 * 通常，字典会实现一种缓存机制，以防止将字典的所有值保存在内存中。
 *
 * @see Initialize
 * @see Close
 *
 *
 */
public interface Dictionary extends ReferenceData, Serializable {

    /**
     * Opens a connection to the {@link Dictionary}. Keep the connection open
     * while using the dictionary in a session, job or so. Close it when you
     * don't expect more interaction.
     *
     * @param configuration
     * @return
     */
    DictionaryConnection openConnection(DataCleanerConfiguration configuration);

    /**
     * Determines if the {@link Dictionary} is defined as "case sensitive"
     * meaning that the dictionary terms can be matched to regardless of text
     * casing.
     *
     * @return
     */
    default boolean isCaseSensitive() {
        return true;
    }
}
