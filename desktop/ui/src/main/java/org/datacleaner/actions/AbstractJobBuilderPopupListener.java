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
package org.datacleaner.actions;

import java.awt.Component;

import javax.swing.Icon;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import org.datacleaner.job.builder.AnalysisJobBuilder;
import org.datacleaner.job.builder.ComponentBuilder;
import org.datacleaner.util.IconUtils;
import org.datacleaner.util.ImageManager;
import org.datacleaner.util.PropertyUtil;
import org.datacleaner.util.WidgetFactory;
import org.datacleaner.widgets.ChangeRequirementMenu;

/**
 * Abstract class containing the action method that will display a popup with
 * options as to change a job builder.
 * 包含操作方法的抽象类，该方法将显示带有选项的弹出窗口，以更改作业生成器。
 */
public abstract class AbstractJobBuilderPopupListener {

    private final AnalysisJobBuilder _analysisJobBuilder;
    private final ComponentBuilder _componentBuilder;

    public AbstractJobBuilderPopupListener(final ComponentBuilder jobBuilder,
            final AnalysisJobBuilder analysisJobBuilder) {
        _componentBuilder = jobBuilder;
        _analysisJobBuilder = analysisJobBuilder;
    }

    public ComponentBuilder getComponentBuilder() {
        return _componentBuilder;
    }

    public AnalysisJobBuilder getAnalysisJobBuilder() {
        return _analysisJobBuilder;
    }

    public void showPopup(final Component parentComponent, final int x, final int y) {
        final Icon renameIcon = ImageManager.get().getImageIcon(IconUtils.ACTION_RENAME, IconUtils.ICON_SIZE_SMALL);
        final JMenuItem renameMenuItem = WidgetFactory.createMenuItem(PropertyUtil.getProperty("datacleaner.ui.desktop.canvas.rename.component"), renameIcon);
        renameMenuItem.addActionListener(new RenameComponentActionListener(_componentBuilder) {
            @Override
            protected void onNameChanged() {
                AbstractJobBuilderPopupListener.this.onNameChanged();
            }
        });

        final JMenuItem removeMenuItem = new RemoveComponentMenuItem(_componentBuilder) {

            private static final long serialVersionUID = 1L;

            @Override
            protected void onRemoved() {
                AbstractJobBuilderPopupListener.this.onRemoved();
            }
        };

        final JPopupMenu popup = new JPopupMenu();
        popup.add(renameMenuItem);
        popup.add(removeMenuItem);
        popup.add(new ChangeRequirementMenu(_componentBuilder));
        popup.show(parentComponent, x, y);
    }

    protected abstract void onNameChanged();

    protected abstract void onRemoved();
}
