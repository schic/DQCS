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
package org.datacleaner.monitor.scheduling;

import org.datacleaner.monitor.scheduling.widgets.SchedulingOverviewPanel;
import org.datacleaner.monitor.shared.ClientConfig;
import org.datacleaner.monitor.shared.DictionaryClientConfig;
import org.datacleaner.monitor.shared.widgets.LoadingIndicator;
import org.datacleaner.monitor.util.ErrorHandler;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * GWT Entry point for the Scheduling module
 */
public class SchedulingEntryPoint implements EntryPoint {

    @Override
    public void onModuleLoad() {
        GWT.setUncaughtExceptionHandler(ErrorHandler.getUncaughtExceptionHandler());

        final ClientConfig clientConfig = new DictionaryClientConfig();

        final SchedulingServiceAsync service = GWT.create(SchedulingService.class);

        final RootPanel rootPanel = RootPanel.get("RootPanelTarget");
        rootPanel.add(new LoadingIndicator());

        final SchedulingOverviewPanel overviewPanel = new SchedulingOverviewPanel(clientConfig, service);
        overviewPanel.initialize(new Runnable() {
            @Override
            public void run() {
                rootPanel.clear();
                rootPanel.add(overviewPanel);
            }
        });
    }

}
