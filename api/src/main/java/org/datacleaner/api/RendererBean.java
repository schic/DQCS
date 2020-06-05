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
 * Annotation used to mark a class as a renderer. Mostly renderers are used for
 * AnalyzerResults, but can also be used as a UI representation of eg.
 * properties, components and more.
 * 用于将类标记为渲染器的注释。
 * 渲染器通常用于AnalyzerResults，但也可以用作UI的表示形式。属性，组件等。
 *
 * Renderers are grouped together by rendering formats, which are defined by the
 * parameter to this annotation. This makes it possible to combine renderers for
 * particular result types and for particular output formats such as HTML,
 * Swing, clear text, XML etc.
 * 渲染器按渲染格式分组，这些格式由此批注的参数定义。
 * 这样就可以为特定的结果类型和特定的输出格式（例如HTML，Swing，明文，XML等）组合渲染器。
 *
 * Renderers are resolved by combining the rendering format with the best
 * fitting output type defined by the Renderer interface.
 * 通过将渲染格式与由Renderer接口定义的最佳拟合输出类型相结合来解析渲染器。
 *
 * The configuration of renderer beans are not standardized since they target
 * very different situations. A RendererFactory is used to retrieve
 * perform instantiation and initialization of a renderer, so any life cycle
 * steps pertaining to renderer initialization and more is dependent on the
 * usage of the RendererFactory.
 * 渲染器bean的配置未标准化，因为它们针对非常不同的情况。
 * RendererFactory用于检索执行渲染器的实例化和初始化，
 * 因此与渲染器初始化有关的任何生命周期步骤及更多步骤都取决于RendererFactory的用法。
 *
 * @see RenderingFormat
 * @see Renderer
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface RendererBean {

    /**
     * Defines the rendering format of this renderer bean.
     *
     * @return the class constant which represents the rendering format.
     */
    Class<? extends RenderingFormat<?>> value();
}
