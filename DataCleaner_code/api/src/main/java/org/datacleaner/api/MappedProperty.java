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

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation used for {@link Configured} properties that are mapped to another
 * {@link Configured} property.
 * 用于{@link Configured}属性的注释，该注释已映射到另一个{@link Configured}属性。
 *
 * Usually the way this works by indicating that two array properties are
 * connected/mapped together. One property would contain an array of
 * {@link InputColumn}s and the other would be an array of Strings, enums or
 * something else. The second would then be mapped to the first, making it
 * possible for each input column to "have" a String or a enum value mapped.
 * 通常，这是通过指示两个数组属性连接/映射在一起来实现的。
 * 一个属性将包含一个{@link InputColumn}数组，另一个属性将是一个字符串，枚举或其他数组。
 * 然后将第二个映射到第一个，从而使每个输入列“具有”映射的String或枚举值成为可能。
 *
 * Another way that properties may be mapped is by hierarchical structure or
 * dependency. For instance, a {@link ColumnProperty} may be mapped to a
 * {@link TableProperty} which indicates that the column should exist within the
 * table.
 * 可以映射属性的另一种方法是通过层次结构或依赖关系。
 * 例如，可以将{@link ColumnProperty}映射到{@link TableProperty}，这表明该列应该存在于表中。
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
@Documented
@Inherited
public @interface MappedProperty {

    /**
     * Defines the name of the other property that this property is mapped to.
     *
     * @return
     */
    String value();
}
