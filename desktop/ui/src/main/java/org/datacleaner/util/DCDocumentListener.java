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
package org.datacleaner.util;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * A simple abstract class that implements DocumentListener. Using this class
 * will make it easier to create DocumentListeners on the fly that delegate to
 * the same method, so you only have to override a single method
 * 一个实现DocumentListener的简单抽象类。
 * 使用此类可以更轻松地动态地创建委托给同一方法的DocumentListeners，因此您只需要重写单个方法
 */
public abstract class DCDocumentListener implements DocumentListener {

    @Override
    public void insertUpdate(final DocumentEvent e) {
        onChange(e);
    }

    @Override
    public void removeUpdate(final DocumentEvent e) {
        onChange(e);
    }

    @Override
    public void changedUpdate(final DocumentEvent e) {
        onChange(e);
    }

    protected abstract void onChange(DocumentEvent event);
}
