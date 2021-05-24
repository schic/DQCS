/**
 * DataCleaner (community edition)
 * Copyright (C) 2014 Neopost - Customer Information Management
 * <p>
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 * <p>
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package org.datacleaner.monitor.scheduling.widgets;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.datacleaner.monitor.home.HomeService;
import org.datacleaner.monitor.home.HomeServiceAsync;
import org.datacleaner.monitor.scheduling.SchedulingServiceAsync;
import org.datacleaner.monitor.scheduling.model.ScheduleDefinition;
import org.datacleaner.monitor.shared.ClientConfig;
import org.datacleaner.monitor.util.DCAsyncCallback;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;

/**
 * Presents an overview of all scheduled activity in DC monitor.
 */
public class HomeOverviewPanel extends Composite {

    private static final String CATEGORY = "Category";
    private static final String OTHERS = "(Other)";
    private final ClientConfig _clientConfig;
    private final HomeServiceAsync _service;

    public HomeOverviewPanel(ClientConfig clientConfig, HomeServiceAsync service) {
        _clientConfig = clientConfig;
        _service = service;
    }

    public void initialize(final Runnable listener) {
        _service.getSchedules(_clientConfig.getTenant(), false, new DCAsyncCallback<List<ScheduleDefinition>>() {
            @Override
            public void onSuccess(List<ScheduleDefinition> result) {
                GWT.log("Categories: " );
                listener.run();
            }
        });
    }



    private Panel createHeaderPanel() {
        final FlowPanel panel = new FlowPanel();
        panel.addStyleName("ColumnHeaders");
        panel.addStyleName("row");

        panel.add(createLabel("任务名称", "col-sm-9", "col-xs-8"));
        panel.add(createLabel("操作", "col-sm-3", "col-xs-4"));

        return panel;
    }

    private Label createLabel(String text, String... styleNames) {
        final Label label = new Label();
        label.setText(text);
        for (String styleName : styleNames) {
            label.addStyleName(styleName);
        }
        return label;
    }
}

