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
package org.datacleaner.storage;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Configurable component which provides storage (for instance cached/persistent
 * or in-memory based) for collections and other types that are needed during
 * execution.
 * 可配置组件，为执行过程中所需的集合和其他类型提供存储（例如，缓存的/持久的或基于内存的）。
 */
public interface StorageProvider {

    <E> List<E> createList(Class<E> valueType) throws IllegalStateException;

    <E> Set<E> createSet(Class<E> valueType) throws IllegalStateException;

    <K, V> Map<K, V> createMap(Class<K> keyType, Class<V> valueType) throws IllegalStateException;

    RowAnnotationFactory createRowAnnotationFactory();
}
