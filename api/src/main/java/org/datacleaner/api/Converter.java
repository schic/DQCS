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

/**
 * Interface for converting objects from and to strings. Used to serialize
 * configured properties to external representations.
 * 用于在字符串之间转换对象的接口。用于将配置的属性序列化为外部表示。
 *
 * Converters should supply a no-args constructor.
 * 转换器应提供一个无参数的构造函数。
 *
 * Usually Converters are registered on a class or a configured property using
 * the {@link Convertable} annotation.
 * 通常，使用{@link Convertable}注释在类或配置的属性上注册转换器。
 *
 * @param <E>
 */
public interface Converter<E> {

    /**
     * Converts a string back to a Java object.
     *
     * @param type
     *            the specific type of object required. This will typically be
     *            the "E" type, but since E can be a supertype, you can use this
     *            type parameter to inspect subtypes.
     * @param serializedForm
     * @return
     */
    E fromString(Class<?> type, String serializedForm);

    /**
     * Converts a Java object into a string.
     *
     * @param instance
     * @return
     */
    String toString(E instance);

    /**
     * Determines if this converter is able to convert the particular type.
     *
     * @param type
     * @return
     */
    boolean isConvertable(Class<?> type);
}
