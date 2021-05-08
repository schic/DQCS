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
package org.datacleaner.widgets;

import java.awt.Component;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.text.JTextComponent;

import org.datacleaner.util.NumberDocument;

/**
 * A combo box for selecing header lines for eg. CSV or fixed width files.
 * 用于选择标题行的组合框。 CSV或固定宽度的文件。
 */
public class HeaderLineComboBox extends DCComboBox<Integer> {

    private static final long serialVersionUID = 1L;

    public HeaderLineComboBox() {
        this(true);
    }

    public HeaderLineComboBox(boolean hasHeaderByDefault) {
        super();
        final JTextComponent headerLineNumberText = (JTextComponent) getEditor().getEditorComponent();
        headerLineNumberText.setDocument(new NumberDocument());
        setEditable(true);
        setModel(new DefaultComboBoxModel<>(new Integer[] { 0, 1 }));
        if (hasHeaderByDefault) {
            setSelectedItem(1);
        }
        setRenderer(new DCListCellRenderer() {

            private static final long serialVersionUID = 1L;

            @Override
            public Component getListCellRendererComponent(final JList<?> list, Object value, final int index,
                    final boolean isSelected, final boolean cellHasFocus) {
                if (value instanceof Integer) {
                    final Integer i = (Integer) value;
                    if (i <= 0) {
                        value = "No header";
                    }
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }

        });
    }
}
