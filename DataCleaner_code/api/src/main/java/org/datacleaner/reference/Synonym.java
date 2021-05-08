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

import java.util.Collection;

/**
 * Represents a single set of synonymuous terms. Each will have a master term
 * (e.g. "William") and a set of synonyms (e.g. "Bill", "Will")
 * 表示一组同义术语。每个人都有一个主术语（例如“ William”）和一组同义词（例如“ Bill”，“ Will”）
 */
public interface Synonym {

    String getMasterTerm();

    Collection<String> getSynonyms();
}
