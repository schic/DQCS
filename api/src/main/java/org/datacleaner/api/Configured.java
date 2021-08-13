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

import javax.inject.Inject;
import javax.inject.Qualifier;

/**
 * Fields with the {@link Inject} and {@link Configured} annotation are used to
 * configure a {@link Component} before execution. Typically, the
 * {@link Configured} annotated fields will be used to prompt the user for
 * configuration in the UI or job definition that is instructing the framework
 * 具有{@link Inject}和{@link Configured}批注的字段用于在执行之前配置{@link Component}。
 * 通常，带{@link Configured}注释字段将用于提示用户在指示框架的UI或作业定义中进行配置
 *
 * In principle any field type can be annotated with {@link Configured}. For
 * serialization and deserialization purposes it may be needed with a
 * {@link Convertable} annotation as well.
 * 原则上，任何字段类型都可以使用{@link Configured}进行注释。
 * 为了进行序列化和反序列化，可能还需要带有{{@link Convertable}注释。
 *
 * In the list of classes below there's a reference of the types that do not
 * need any {@link Convertable} annotation. Furthermore arrays of all these
 * types are supported:
 * 在下面的类列表中，有不需要任何{@link Convertable}注释的类型的引用。此外，还支持所有这些类型的数组：
 * <ul>
 * <li>Boolean</li>
 * <li>Byte</li>
 * <li>Short</li>
 * <li>Integer</li>
 * <li>Long</li>
 * <li>Float</li>
 * <li>Double</li>
 * <li>Character</li>
 * <li>String</li>
 * <li>java.io.File</li>
 * <li>enum types</li>
 * <li>java.util.regex.Pattern</li>
 * <li>org.datacleaner.data.InputColumn</li>
 * <li>org.datacleaner.reference.Dictionary</li>
 * <li>org.datacleaner.reference.SynonymCatalog</li>
 * <li>org.datacleaner.reference.StringPattern</li>
 * <li>org.apache.metamodel.schema.Column</li>
 * <li>org.apache.metamodel.schema.Table</li>
 * <li>org.apache.metamodel.schema.Schema</li>
 * </ul>
 *
 * In addition to the name of the {@link Configured} property (provided via
 * {@link #value()}) a number of aliases can be provided via the {@link Alias}
 * annotation. This is particularly useful when renaming properties - adding an
 * alias with the old names will help retain backwards compatibility.
 * 除了{@link Configured}属性的名称（通过{@link #value（）}提供）之外，
 * 还可以通过{@link Alias}注释提供多个别名。重命名属性时，此功能特别有用-使用旧名称添加别名将有助于保持向后兼容性。
 *
 * Details of the property can be provided to the end user via the
 * {@link Description} annotation.
 * 可以通过{@link Description}注释将属性的详细信息提供给最终用户。
 *
 * Fields may also be annotated with {@link StringProperty},
 * {@link NumberProperty}, {@link ColumnProperty}, {@link TableProperty},
 * {@link SchemaProperty} or {@link FileProperty}. These annotations provide
 * extra type-specific metadata relevant for corresponding property types.
 * 字段也可以用{@link StringProperty}，{@link NumberProperty}，
 * {@link ColumnProperty}，{@link TableProperty}，{@link SchemaProperty}
 * 或{@link FileProperty}进行注释。这些批注提供与特定属性类型相关的额外的特定于类型的元数据。
 *
 * If a property represents an array, and this array is mapped to another
 * configured array, then the {@link MappedProperty} annotation can be applied
 * to indicate this relationship.
 * 如果一个属性表示一个数组，并且该数组映射到另一个配置的数组，
 * 则可以应用{@link MappedProperty}批注以指示这种关系。
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
@Documented
@Inherited
@Qualifier
public @interface Configured {

    /**
     * Defines the name of the required configuration property.
     *
     * @return the name of the configuration property
     */
    String value() default "";

    /**
     * Defines whether or not this configured property is required
     *
     * @return true if the configured property is required
     */
    boolean required() default true;

    /**
     * Defines the display order of this configured property, relative to other
     * properties.
     *
     * @return the order (if any) of this configured property when sorting
     *         properties of a component. A low order will place the property
     *         before higher order properties.
     */
    int order() default Integer.MAX_VALUE;
}
