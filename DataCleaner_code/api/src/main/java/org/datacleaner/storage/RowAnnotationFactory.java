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

import org.datacleaner.api.Component;
import org.datacleaner.api.Provided;

/**
 * The RowAnnotationFactory represents a mechanism used to annotate/label rows
 * of data during execution. Typically these annotations will be stored on disk
 * and thus provide a convenient storage mechanism for situations where a
 * component needs to manage a set of labels but where storing them in
 * collections would be too complicated and would fill up memory.
 * RowAnnotationFactory表示一种用于在执行过程中对数据行进行注释/标签的机制。
 * 通常，这些批注将存储在磁盘上，
 * 从而为组件需要管理一组标签但将它们存储在集合中的情况过于复杂并会占用内存的情况提供一种便捷的存储机制。
 *
 * The RowAnnotationFactory is injectable into any {@link Component} (analyzer,
 * transformer, filter) using the {@link Provided} annotation.
 * 使用{@link Provided}批注，可以将RowAnnotationFactory注入到任何{@link Component}（分析仪，转换器，过滤器）中。
 */
public interface RowAnnotationFactory extends RowAnnotationSampleContainer, RowAnnotationHandler {

    /**
     * Creates a new annotation
     *
     * @return a new annotation
     */
    RowAnnotation createAnnotation();

}
