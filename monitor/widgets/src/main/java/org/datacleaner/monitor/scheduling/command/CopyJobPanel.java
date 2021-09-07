package org.datacleaner.monitor.scheduling.command;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.TextBox;

public class CopyJobPanel extends FlowPanel {
    private final TextBox _input;
    public CopyJobPanel() {
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
