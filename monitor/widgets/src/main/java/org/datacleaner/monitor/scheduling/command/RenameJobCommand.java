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
package org.datacleaner.monitor.scheduling.command;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import org.datacleaner.monitor.dashboard.model.DashboardGroup;
import org.datacleaner.monitor.shared.model.JobIdentifier;
import org.datacleaner.monitor.shared.model.TenantIdentifier;
import org.datacleaner.monitor.shared.widgets.CancelPopupButton;
import org.datacleaner.monitor.shared.widgets.DCButtons;
import org.datacleaner.monitor.shared.widgets.DCPopupPanel;
import org.datacleaner.monitor.shared.widgets.LoadingIndicator;
import org.datacleaner.monitor.util.*;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.Response;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;

public class RenameJobCommand implements Command {
 
	private TenantIdentifier _tenant;
	private JobIdentifier _job ; 
	private DCPopupPanel _morePopup;
	
	public RenameJobCommand(TenantIdentifier tenant,JobIdentifier jobIdentifier, DCPopupPanel morePopup) {
		_tenant = tenant;
		_job = jobIdentifier; 
		_morePopup = morePopup;
	}
	
	@Override
	public void execute() {
		_morePopup.hide();
        DCPopupPanel popuptop = new DCPopupPanel("请重命名任务名称");
        popuptop.setHeader("任务原名："+_job.getName());
        final ReNamePanel inputValuePanel =new ReNamePanel();
        popuptop.setWidget(inputValuePanel);

        Button okButton = DCButtons.primaryButton(null, "确定");
        okButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                String newName = inputValuePanel.getInputValue();
                if (newName == null || newName.trim().length() == 0 || newName.equals(_job.getName())) {
                    return;
                }
                final DCPopupPanel popup = new DCPopupPanel("任务正在重命名中......");
                popup.setWidget(new LoadingIndicator());
                popup.center();
                popup.show();
                final String url = Urls.createRepositoryUrl(_tenant, "jobs/" + _job.getName() + ".modify");

                final JSONObject payload = new JSONObject();
                payload.put("name", new JSONString(newName));

                final DCRequestBuilder requestBuilder = new DCRequestBuilder(RequestBuilder.POST, url);
                requestBuilder.setHeader("Content-Type", "application/json");
                requestBuilder.send(payload.toString(), new DCRequestCallback() {
                    @Override
                    protected void onSuccess(Request request, Response response) {
                        Window.Location.reload();
                    }

                    @Override
                    public void onNonSuccesfullStatusCode(Request request, Response response, int statusCode, String statusText) {
                        popup.hide();
                        ErrorHandler.showErrorDialog(response.getText());
                    }
                });
                popuptop.hide();
            }
        });
        popuptop.addButton(new CancelPopupButton(popuptop));
        popuptop.addButton(okButton);
        popuptop.center();
        popuptop.show();
    }
}
