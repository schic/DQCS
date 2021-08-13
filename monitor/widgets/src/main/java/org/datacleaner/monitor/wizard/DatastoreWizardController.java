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

import org.datacleaner.monitor.shared.JavaScriptCallbacks;
import org.datacleaner.monitor.shared.WizardServiceAsync;
import org.datacleaner.monitor.shared.model.TenantIdentifier;
import org.datacleaner.monitor.shared.model.WizardIdentifier;
import org.datacleaner.monitor.shared.widgets.DCButtons;
import org.datacleaner.monitor.util.DCAsyncCallback;
import org.datacleaner.monitor.util.Urls;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;

/**
 * Wizard controller for Datastore wizards
 * 数据存储向导的向导控制器
 */
public class DatastoreWizardController extends AbstractWizardController<WizardServiceAsync> {

    private int _stepsBeforeWizardPages;

    public DatastoreWizardController(WizardPanel wizardPanel, TenantIdentifier tenant,
            WizardIdentifier wizardIdentifier, WizardServiceAsync wizardService) {
        super(wizardPanel, tenant, wizardIdentifier, wizardService);

        _stepsBeforeWizardPages = 0;
        if (wizardIdentifier == null) {
            _stepsBeforeWizardPages++;
        }
    }

    @Override
    public void startWizard() {
        getWizardPanel().addStyleClass("JobWizardPanel");
        getWizardPanel().showWizard();

        final WizardIdentifier wizardIdentifier = getWizardIdentifier();

        if (wizardIdentifier == null) {
            showWizardSelection();
            return;
        }

        getWizardPanel().setHeader("Register datastore: " + wizardIdentifier.getDisplayName());
        setLoading();

        WizardServiceAsync wizardService = getWizardService();
        wizardService.startDatastoreWizard(getTenant(), wizardIdentifier, getLocaleName(), createNextPageCallback());
    }

    private void showWizardSelection() {
        setLoading();
        getWizardPanel().setHeader("Register datastore");

        getWizardService().getDatastoreWizardIdentifiers(getTenant(), getLocaleName(),
                new DCAsyncCallback<List<WizardIdentifier>>() {
                    @Override
                    public void onSuccess(List<WizardIdentifier> wizards) {
                        showWizardSelection(wizards);
                    }
                });
    }

    private void showWizardSelection(final List<WizardIdentifier> wizards) {
        final FlowPanel panel = new FlowPanel();

        panel.add(new Label("请选择要注册的数据存储类型："));

        final List<RadioButton> radios = new ArrayList<RadioButton>(wizards.size());

        if (wizards == null || wizards.isEmpty()) {
            panel.add(new Label("(no datastore wizards available)"));
        } else {
            for (final WizardIdentifier wizard : wizards) {
                final RadioButton radio = new RadioButton("wizardIdentifier", wizard.getDisplayName());
                radio.addClickHandler(new ClickHandler() {
                    @Override
                    public void onClick(ClickEvent event) {
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
                    if (radio.getValue().booleanValue()) {
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
    protected void wizardFinished(final String datastoreName) {
        final String encodedDatastoreName = URL.encodeQueryString(datastoreName);

        final Button button = DCButtons.primaryButton(null, "关闭");
        button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                // full page refresh.
                closeWizardAfterFinishing(datastoreName, "datastores");
            }
        });

        final Anchor jobWizardAnchor = new Anchor("为此数据存储建立工作");
        jobWizardAnchor.addStyleName("BuildJob");
        jobWizardAnchor.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                final String htmlDivId = getWizardPanel().getCustomHtmlDivId();
                closeWizardAfterFinishing(datastoreName, null);

                JavaScriptCallbacks.startJobWizard(datastoreName, null, htmlDivId);
            }
        });

        final Anchor queryAnchor = new Anchor("浏览/查询此数据存储");
        queryAnchor.addStyleName("QueryDatastore");
        queryAnchor.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                final String url = Urls.createRelativeUrl("query?ds=" + encodedDatastoreName);
                Window.open(url, "_blank", "location=no,width=770,height=400,toolbar=no,menubar=no");
            }
        });

        final FlowPanel contentPanel = new FlowPanel();
        contentPanel.addStyleName("WizardFinishedPanel");
        contentPanel.add(new Label("数据存储区'" + datastoreName + "'已创建！向导完成。"));

        contentPanel.add(new Label(
                "单击“关闭”返回，或单击下面的链接之一开始使用数据存储。"));
        contentPanel.add(jobWizardAnchor);
        contentPanel.add(queryAnchor);

        setContent(contentPanel);
        getWizardPanel().getButtonPanel().clear();
        getWizardPanel().getButtonPanel().addButton(button);
        getWizardPanel().refreshUI();
    }

}
