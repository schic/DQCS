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
 * An enum that represents the precedence of a particular {@link Renderer} over
 * others. The precendence is used to allow renderers of the same type to have
 * different precedence properties based on eg. the state of the renderable to
 * be rendered.
 * 代表特定{@link Renderer}优先于其他的枚举。
 * 优先级用于允许相同类型的渲染器基于提供不同的优先级属性。要渲染的可渲染状态。
 *
 * A low precedence means that renderers with such precedence will only be
 * applied if no higher-ranked renderers are found.
 * 较低的优先级意味着只有在未找到排名较高的渲染器时，才会应用具有此类优先级的渲染器。
 */
public enum RendererPrecedence {

    NOT_CAPABLE, LOWEST, LOW, MEDIUM, HIGH, HIGHEST
}
