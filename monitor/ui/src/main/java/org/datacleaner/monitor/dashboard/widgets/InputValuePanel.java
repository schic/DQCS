package org.datacleaner.monitor.dashboard.widgets;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.TextBox;
import org.datacleaner.monitor.dashboard.DashboardServiceAsync;
import org.datacleaner.monitor.shared.model.TenantIdentifier;
import org.datacleaner.monitor.shared.widgets.HeadingLabel;
import org.datacleaner.monitor.shared.widgets.LoadingIndicator;


public class InputValuePanel extends FlowPanel {

    private final DashboardServiceAsync _service;
    private final TenantIdentifier _tenant;
    private final LoadingIndicator _loadingIndicator;
    private final TextBox _input;

    public InputValuePanel(DashboardServiceAsync service, TenantIdentifier tenant) {
        _service = service;
        _tenant = tenant;
        _loadingIndicator = new LoadingIndicator();
        _input = new TextBox();
        _input.addStyleName("form-control");
        addStyleName("InputValuePanel");
        _input.setVisible(true);
//        add(_loadingIndicator);
        add(_input);
    }

    public String getInputValue() {
        return _input.getValue();
    }
}
