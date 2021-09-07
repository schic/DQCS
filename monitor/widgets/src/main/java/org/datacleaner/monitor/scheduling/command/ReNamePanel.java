package org.datacleaner.monitor.scheduling.command;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.TextBox;

public class ReNamePanel extends FlowPanel {
    private final TextBox _input;
    public ReNamePanel() {
        _input = new TextBox();
        _input.addStyleName("form-control");
        addStyleName("InputValuePanel");
        _input.setVisible(true);
        add(_input);
    }

    public String getInputValue() {
        return _input.getValue();
    }
}
