package org.datacleaner.monitor.home;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import org.datacleaner.monitor.scheduling.SchedulingService;
import org.datacleaner.monitor.scheduling.SchedulingServiceAsync;
import org.datacleaner.monitor.scheduling.widgets.HomeOverviewPanel;
import org.datacleaner.monitor.scheduling.widgets.SchedulingOverviewPanel;
import org.datacleaner.monitor.shared.ClientConfig;
import org.datacleaner.monitor.shared.DictionaryClientConfig;
import org.datacleaner.monitor.shared.widgets.LoadingIndicator;
import org.datacleaner.monitor.util.ErrorHandler;

public class HomeEntryPoint implements EntryPoint {
    @Override
    public void onModuleLoad() {
        GWT.setUncaughtExceptionHandler(ErrorHandler.getUncaughtExceptionHandler());

        final ClientConfig clientConfig = new DictionaryClientConfig();

        final HomeServiceAsync service = GWT.create(HomeService.class);

        final RootPanel rootPanel = RootPanel.get("RootPanelTarget");
        rootPanel.add(new LoadingIndicator());

        final HomeOverviewPanel overviewPanel = new HomeOverviewPanel(clientConfig, service);
        overviewPanel.initialize(new Runnable() {
            @Override
            public void run() {
                rootPanel.clear();
                rootPanel.add(overviewPanel);
            }
        });
    }
}
