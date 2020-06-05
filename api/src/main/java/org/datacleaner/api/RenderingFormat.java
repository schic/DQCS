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
 * Represents a rendering format to be used for rendering. DataCleaner ships
 * with a couple of built-in rendering formats (eg. HTML and Text), but it is
 * also possible to roll your own. Simply create a class that implements this
 * interface and reference the class in the @RendererBean annotation when
 * implementing renderers.
 * 表示用于渲染的渲染格式。 DataCleaner附带了一些内置的呈现格式（例如HTML和Text），
 * 但是也可以自己滚动。只需创建实现此接口的类，并在实现渲染器时在@RendererBean批注中引用该类。
 *
 * @param <T>
 *
 * @see RendererBean
 * @see Renderer
 */
public interface RenderingFormat<T> {

    Class<T> getOutputClass();
}
