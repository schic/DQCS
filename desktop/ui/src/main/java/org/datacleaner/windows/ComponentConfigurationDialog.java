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
package org.datacleaner.windows;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

import org.datacleaner.actions.ComponentReferenceDocumentationActionListener;
import org.datacleaner.actions.RenameComponentActionListener;
import org.datacleaner.api.Renderer;
import org.datacleaner.bootstrap.WindowContext;
import org.datacleaner.job.builder.AnalysisJobBuilder;
import org.datacleaner.job.builder.ComponentBuilder;
import org.datacleaner.job.builder.ComponentRemovalListener;
import org.datacleaner.panels.ComponentBuilderPresenter;
import org.datacleaner.panels.DCBannerPanel;
import org.datacleaner.panels.DCPanel;
import org.datacleaner.util.*;
import org.datacleaner.widgets.Alignment;
import org.datacleaner.widgets.ChangeRequirementButton;
import org.datacleaner.widgets.ChangeRequirementMenu;
import org.datacleaner.widgets.visualization.ComponentScopeButton;
import org.datacleaner.widgets.visualization.ComponentScopeMenuBuilder;
import org.datacleaner.widgets.visualization.JobGraph;

/**
 * Dialog for configuring components that have been selected through the
 * {@link JobGraph}.
 * 用于配置通过{@link JobGraph}选择的组件的对话框。
 */
public class ComponentConfigurationDialog extends AbstractDialog implements ComponentRemovalListener<ComponentBuilder> {

    private static final long serialVersionUID = 1L;

    private static final WidgetScreenResolutionAdjuster adjuster = WidgetScreenResolutionAdjuster.get();
    private final ComponentBuilder _componentBuilder;
    private final ComponentScopeButton _componentScopeButton;
    private final ChangeRequirementButton _changeRequirementButton;
    private final Renderer<ComponentBuilder, ? extends ComponentBuilderPresenter> _renderer;
    private boolean _changingScope;

    public ComponentConfigurationDialog(final WindowContext windowContext, final ComponentBuilder componentBuilder,
            final Renderer<ComponentBuilder, ? extends ComponentBuilderPresenter> renderer) {
        super(windowContext, getBannerImage(componentBuilder));

        _componentBuilder = componentBuilder;
        _componentBuilder.addRemovalListener(this);
        _renderer = renderer;
        final ComponentScopeMenuBuilder menuBuilder = new ComponentScopeMenuBuilder(_componentBuilder) {
            @Override
            protected void onScopeChangeStart() {
                _changingScope = true;
            }

            @Override
            protected void onScopeChangeComplete(final AnalysisJobBuilder osJobBuilder,
                    final ComponentBuilder osComponentBuilder) {
                _changingScope = false;
                _componentScopeButton.updateText(osJobBuilder, osComponentBuilder);

                _changeRequirementButton.updateText();
                _changeRequirementButton.setVisible(ChangeRequirementMenu.isRelevant(_componentBuilder));
                initialize();
            }
        };

        _componentScopeButton = new ComponentScopeButton(_componentBuilder, menuBuilder);
        _changeRequirementButton = new ChangeRequirementButton(_componentBuilder);
    }

    private static Image getBannerImage(final ComponentBuilder componentBuilder) {
        final ImageIcon descriptorIcon =
                IconUtils.getDescriptorIcon(componentBuilder.getDescriptor(), IconUtils.ICON_SIZE_LARGE);
        return descriptorIcon.getImage();
    }

    @Override
    protected boolean isWindowResizable() {
        return true;
    }

    @Override
    public String getWindowTitle() {
        return getBannerTitle2(false);
    }

    @Override
    protected String getBannerTitle() {
        return _componentBuilder.getDescriptor().getDisplayName();
    }

    private String getBannerTitle2(final boolean onlyIfDifferentThanTitle1) {
        final String title2 = LabelUtils.getLabel(_componentBuilder);
        if (onlyIfDifferentThanTitle1 && getBannerTitle().equals(title2)) {
            return null;
        }
        return title2;
    }

    @Override
    protected DCBannerPanel createBanner(final Image bannerImage) {
        final DCBannerPanel banner = new DCBannerPanel(bannerImage, getBannerTitle());
        banner.setTitle2(getBannerTitle2(true));

        final JButton renameButton = WidgetFactory.createDefaultButton(PropertyUtil.getProperty("datacleaner.ui.desktop.canvas.raname"), IconUtils.ACTION_RENAME);
        renameButton.addActionListener(new RenameComponentActionListener(_componentBuilder) {
            @Override
            protected void onNameChanged() {
                banner.setTitle2(getBannerTitle2(true));
                banner.updateUI();
            }
        });

        final JButton documentationButton =
                WidgetFactory.createDefaultButton(PropertyUtil.getProperty("datacleaner.ui.desktop.canvas.documentation"), IconUtils.MENU_DOCUMENTATION);
        documentationButton.addActionListener(new ComponentReferenceDocumentationActionListener(
                _componentBuilder.getAnalysisJobBuilder().getConfiguration(), _componentBuilder.getDescriptor()));

        if (_componentScopeButton.isRelevant()) {
            banner.add(_componentScopeButton);
        }

        banner.add(documentationButton);

        _changeRequirementButton.setVisible(ChangeRequirementMenu.isRelevant(_componentBuilder));
        banner.add(_changeRequirementButton);


        banner.add(renameButton);

        return banner;
    }

    @Override
    protected int getDialogWidth() {
        return WidgetUtils.DIALOG_WIDTH_WIDE;
    }

    @Override
    protected int getDialogHeightBuffer() {
        return 50;
    }

    @Override
    protected JComponent getDialogContent() {
        final JComponent configurationComponent = _renderer.render(_componentBuilder).createJComponent();

        final JButton closeButton = WidgetFactory.createPrimaryButton("关闭", IconUtils.ACTION_CLOSE_BRIGHT);
        closeButton.addActionListener(e -> ComponentConfigurationDialog.this.dispose());

        final DCPanel panel = new DCPanel(WidgetUtils.COLOR_WELL_BACKGROUND);
        panel.setLayout(new BorderLayout());
        panel.add(configurationComponent, BorderLayout.CENTER);
        panel.add(DCPanel.flow(Alignment.CENTER, closeButton), BorderLayout.SOUTH);
        panel.setPreferredSize(adjuster.adjust(700), adjuster.adjust(500));
        return panel;
    }

    @Override
    public void onRemove(final ComponentBuilder componentBuilder) {
        if (!_changingScope) {
            close();
        }
    }
}
