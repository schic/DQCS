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
package org.datacleaner.metadata;

import org.apache.metamodel.schema.Column;
import org.apache.metamodel.util.HasName;

/**
 * Defines metadata about a group of {@link Column}s that logically belong
 * together, e.g. all columns pertaining to an address, a name or something like
 * that.
 * 定义有关一组在逻辑上属于的{@link Column}的元数据，例如与地址，名称或类似的所有列。
 */
public interface ColumnGroupMetadata extends HasName, HasMetadataAnnotations, HasColumnMetadata {

}
