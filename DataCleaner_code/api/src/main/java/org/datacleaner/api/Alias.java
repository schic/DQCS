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
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation used to specify optional alias(es) for a component, a
 * {@link Configured} property or a {@link Metric} method.
 * 用于为组件，{@link Configured}属性或{@link Metric}方法指定可选别名的注释。
 *
 * Aliases can be used as a way of providing backwards compatibility to
 * components or properties that are renamed (by specifying the old name as an
 * alias).
 * 别名可以用作向被重命名的组件或属性提供向后兼容性的方式（通过将旧名称指定为别名）。
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.TYPE })
@Documented
public @interface Alias {

    /**
     * Defines the alias(es) of the component or configured property.
     *
     * @return the aliases of the component or configuration property
     */
    String[] value();
}
