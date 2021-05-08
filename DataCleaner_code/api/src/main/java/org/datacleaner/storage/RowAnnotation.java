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

import java.io.Serializable;

/**
 * Represents an annotation (aka a mark, a label or a categorization) of a row.
 * RowAnnotations are used typically by analyzers in order to label rows for
 * later use, typically drill-to-detail functionality.
 * 表示行的注释（又名标记，标签或分类）。
 * 分析器通常使用RowAnnotations来标记行以供以后使用，通常是钻取到细节功能。
 *
 * RowAnnotations are created through the RowAnnotationFactory, which is
 * injectable using the @Provided annotation.
 * RowAnnotations是通过RowAnnotationFactory创建的，该工厂可以使用@Provided注解进行注入。
 *
 * @see RowAnnotationFactory
 */
public interface RowAnnotation extends Serializable {

    int getRowCount();
}
