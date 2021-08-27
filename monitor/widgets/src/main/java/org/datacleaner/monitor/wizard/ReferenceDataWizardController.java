/**
 * DataCleaner (community edition)
 * Copyright (C) 2014 Neopost - Customer Information Management
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
package org.datacleaner.monitor.wizard;

import java.util.ArrayList;
import java.util.List;

import org.datacleaner.monitor.shared.WizardServiceAsync;
import org.datacleaner.monitor.shared.model.TenantIdentifier;
import org.datacleaner.monitor.shared.model.WizardIdentifier;
import org.datacleaner.monitor.shared.widgets.DCButtons;
import org.datacleaner.monitor.util.DCAsyncCallback;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;

/**
 * Wizard controller for reference data wizards.
 * 向导控制器，用于参考数据向导。
 */
public class ReferenceDataWizardController extends AbstractWizardController<WizardServiceAsync> {

    private int _stepsBeforeWizardPages;
    private final String _referenceDataType;

    public ReferenceDataWizardController(String referenceDataType, WizardPanel wizardPanel, TenantIdentifier tenant,
            WizardIdentifier wizardIdentifier, WizardServiceAsync wizardService) {
        super(wizardPanel, tenant, wizardIdentifier, wizardService);
        _referenceDataType = referenceDataType;
        _stepsBeforeWizardPages = 0;

        if (wizardIdentifier == null) {
            _stepsBeforeWizardPages++;
        }
    }

    @Override
    public void startWizard() {
        getWizardPanel().addStyleClass("ReferenceDataWizardPanel");
        getWizardPanel().showWizard();

        final WizardIdentifier wizardIdentifier = getWizardIdentifier();

        if (wizardIdentifier == null) {
            showWizardSelection();
            return;
        }

        getWizardPanel().setHeader("注册字典参考数据: " + wizardIdentifier.getDisplayName());
        setLoading();

        WizardServiceAsync wizardService = getWizardService();
        wizardService
                .startReferenceDataWizard(getTenant(), wizardIdentifier, getLocaleName(), createNextPageCallback());
    }

    private void showWizardSelection() {
        setLoading();
        getWizardPanel().setHeader("注册字典参考数据");
        getWizardService().getReferenceDataWizardIdentifiers(_referenceDataType, getTenant(), getLocaleName(),
                new DCAsyncCallback<List<WizardIdentifier>>() {
                    @Override
                    public void onSuccess(List<WizardIdentifier> wizards) {
                        showWizardSelection(wizards);
                    }
                });
    }

    private void showWizardSelection(final List<WizardIdentifier> wizards) {
        final FlowPanel panel = new FlowPanel();
        Label labelLeo = new Label("字典是参考数据列表，用于对照某些黑名单或白名单对值进行验证或分类,字典通常是可枚举的和有限的。\n" +
                "\t词典示例如下：\n" +
                "\t--产品类型字典，如“珠宝”、“男装”、“运动装”等。\n" +
                "\t--性别符号的字典，比如“M”、“F”或者“未知”。\n" +
                "\t--年龄组名称词典（如婴儿、儿童、年轻人、成熟人、老年人）\n" +
                "\t--两本男性和女性名字词典（以确定人的性别）");
        labelLeo.addStyleName("white-space:pre-wrap");
        panel.add(labelLeo);
        panel.add(new Label("请选择要注册的参考数据类型："));
        final List<RadioButton> radios = new ArrayList<>(wizards.size());

        if (wizards.isEmpty()) {
            panel.add(new Label("(没有可用的参考数据向导)"));
        } else {
            for (final WizardIdentifier wizard : wizards) {
                final RadioButton radio = new RadioButton("wizardIdentifier", wizard.getDisplayName());
                radio.addClickHandler(new ClickHandler() {
                    @Override
                    public void onClick(final ClickEvent clickEvent) {
                        setSteps(wizard.getExpectedPageCount() + getStepsBeforeWizardPages());
                        setProgress(0);
                    }
                });
                panel.add(radio);
                radios.add(radio);
            }
        }

        setNextClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                for (int i = 0; i < radios.size(); i++) {
                    final RadioButton radio = radios.get(i);

                    if (radio.getValue()) {
                        final WizardIdentifier wizard = wizards.get(i);
                        setWizardIdentifier(wizard);
                        startWizard();
                        return;
                    }
                }
            }
        });

        setContent(panel);
        getWizardPanel().refreshUI();
    }

    @Override
    protected int getStepsBeforeWizardPages() {
        return _stepsBeforeWizardPages;
    }

    @Override
    protected void wizardFinished(final String referenceDataName) {
        final Button button = DCButtons.primaryButton(null, "Close");
        button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                closeWizardAfterFinishing(referenceDataName, "referencedata");
            }
        });

        final FlowPanel contentPanel = new FlowPanel();
        contentPanel.addStyleName("WizardFinishedPanel");
        contentPanel.add(new Label("创建了新的参考数据！向导已完成。"));
        contentPanel.add(new Label("单击“关闭”返回。"));
        setContent(contentPanel);
        getWizardPanel().getButtonPanel().clear();
        getWizardPanel().getButtonPanel().addButton(button);
        getWizardPanel().refreshUI();
    }
}
