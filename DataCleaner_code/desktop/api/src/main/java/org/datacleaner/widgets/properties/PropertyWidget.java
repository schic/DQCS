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
package org.datacleaner.widgets.properties;

import javax.swing.JComponent;

import org.datacleaner.descriptors.ConfiguredPropertyDescriptor;

/**
 * Defines an interface for (wrappers of) widgets that are used to edit
 * configurable properties of analyzers, transformers and filters.
 * 为小部件（的包装）定义一个接口，这些小部件用于编辑分析器，转换器和过滤器的可配置属性。
 *
 * @param <E>
 */
public interface PropertyWidget<E> {

    /**
     * Initializes the property widget with the initial value of the property
     *      ----用属性的初始值初始化属性小部件
     * @param value
     */
    void initialize(E value);

    /**
     * Gets the visual widget to show on the UI. This may (in special cases)
     * return null if the widget should not be shown, or if it is represented as
     * part of a different part of the UI.
     *      ----获取要在UI上显示的可视小部件。如果小部件不应该被显示，
     *      或者如果它被表示为UI的不同部分，那么它可能（在特殊情况下）返回null。
     *
     * @return
     */
    JComponent getWidget();

    /**
     * Gets the {@link ConfiguredPropertyDescriptor} that this
     * {@link PropertyWidget} is modelling.
     *      ----获取此{@link PropertyWidget}正在建模的{@link ConfiguredPropertyDescriptor}。
     * @return
     */
    ConfiguredPropertyDescriptor getPropertyDescriptor();

    /**
     * Called on a widget if the value it contains is prone to have been changed
     * by a another party (typically some sort of shortcut in the UI to populate
     * values or similar).
     *
     * Note that this method will sometimes also be invoked at when the
     * surrounding environment is not able to determine if it has changed or
     * not. The property widget should therefore investigate if the incoming
     * value does in deed differ from the existing.
     *      ----如果小部件包含的值容易被另一方更改（通常是UI中用于填充值或类似内容的某种快捷方式），则在该小部件上调用。
     *      请注意，当周围环境无法确定该小部件是否已更改时，有时也会调用此方法。
     *      因此，property小部件应该调查传入值是否确实与现有值不同。
     */
    void onValueTouched(E value);

    /**
     * Determines if the property is set given the current state in the UI.
     *      ----确定是否根据UI中的当前状态设置属性。
     * @return
     */
    boolean isSet();

    /**
     * Gets the current value of the property given the current state in the UI.
     *      ----获取给定UI中当前状态的属性的当前值。
     * @return
     */
    E getValue();
}
