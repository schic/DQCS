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
package org.datacleaner.panels;

import org.datacleaner.api.RenderingFormat;
import org.datacleaner.job.builder.ComponentBuilder;

/**
 * Renderer format for component job builder presenters. Renderers of
 * {@link ComponentBuilder}s should use this rendering format.
 * 组件作业生成器演示者的渲染器格式。{@link ComponentBuilder}的渲染器应使用此渲染格式。
 */
public class ComponentBuilderPresenterRenderingFormat implements RenderingFormat<ComponentBuilderPresenter> {

    @Override
    public Class<ComponentBuilderPresenter> getOutputClass() {
        return ComponentBuilderPresenter.class;
    }

}
