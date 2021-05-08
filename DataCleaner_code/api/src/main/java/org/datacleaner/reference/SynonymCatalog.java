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

import org.datacleaner.configuration.DataCleanerConfiguration;

/**
 * A synonym catalog represents a set of synonyms which are related.
 * 同义词目录表示一组相关的同义词。
 *
 * Meaningful examples of synonym catalogs:
 * <ul>
 * <li>Country names (with ISO code as master term)</li>
 * <li>Given name synonyms (eg. 'William' is the master term for 'Billy')</li>
 * </ul>
 * 同义词目录的有意义的示例：
 * 国家名称（以ISO代码为主要术语）
 * 给定名称的同义词（例如“ William”是“ Billy”的主要术语）
 */
public interface SynonymCatalog extends ReferenceData {

    /**
     * Gets the name of this synonym catalog
     *
     * @return
     */
    String getName();

    /**
     * Opens a connection to the {@link SynonymCatalog}. Keep the connection
     * open while using the synonym catalog in a session, job or so. Close it
     * when you don't expect more interaction.
     *
     * @param configuration
     * @return
     */
    SynonymCatalogConnection openConnection(DataCleanerConfiguration configuration);

    default boolean isCaseSensitive() {
        return true;
    }
}
