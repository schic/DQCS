package org.datacleaner.panels.jleo;

import org.datacleaner.bootstrap.WindowContext;
import org.datacleaner.descriptors.ConfiguredPropertyDescriptor;
import org.datacleaner.job.builder.ComponentBuilder;
import org.datacleaner.panels.DCPanel;
import org.datacleaner.widgets.properties.AbstractPropertyWidget;
import org.jdesktop.swingx.HorizontalLayout;
import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * @Description 附表时间范围
 * @Author Leo
 * @Date 2021/3/30
 **/
public class LeoSingleDatePropertyWidget extends AbstractPropertyWidget<String> {
    private final JLabel _valueLabel;
    private final HashMap<String,String> _dateStringMap;
    private final JXDatePicker _datePicker_start;
    private final JLabel _linkLabel;
    private final JXDatePicker _datePicker_end;
    private final SimpleDateFormat simpleDateFormat;
    private static final String DATE_FORMAT = "yyyy-MM-dd hh:mm:ss";
    private static final String KEY_START = "start";
    private static final String KEY_END = "end";

    public LeoSingleDatePropertyWidget(final ConfiguredPropertyDescriptor propertyDescriptor,
                                       final ComponentBuilder componentBuilder, final WindowContext windowContext) {
        super(componentBuilder, propertyDescriptor);
        simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
        _dateStringMap = createDateStringMap();
        _valueLabel = createValueLabel();
        _linkLabel = new JLabel("--- TO ---");
        _datePicker_start = createDatePickerStart();
        _datePicker_end = createDatePickerEnd();
        createContent();
    }

    private HashMap createDateStringMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put(KEY_START,"");
        map.put(KEY_END,"");
        return map;
    }
    private JLabel createValueLabel() {
        final JLabel valueLabel = new JLabel();
        valueLabel.setVisible(false);
        return valueLabel;
    }

    private JXDatePicker createDatePickerStart() {
        final JXDatePicker datePicker = new JXDatePicker();
        datePicker.setFormats(DATE_FORMAT);
        datePicker.addActionListener(e -> {
            updateValueLabelStart();
        });
        datePicker.getEditor().addFocusListener(new FocusListener() {
            @Override
            public void focusGained(final FocusEvent e) {

            }

            @Override
            public void focusLost(final FocusEvent e) {
                // this for some reason does not work properly, so value can not be updated here
            }
        });
        return datePicker;
    }
    private void updateValueLabelStart() {
        final Date date = _datePicker_start.getDate();
        if (date != null ) {
            _dateStringMap.remove("start");
            _dateStringMap.put("start",simpleDateFormat.format(date));
        }
        if (!_dateStringMap.get(KEY_END).isEmpty()){
            _valueLabel.setText(_dateStringMap.get(KEY_START).concat("||").concat(_dateStringMap.get(KEY_END)));
        }
        fireValueChanged();
    }

    private JXDatePicker createDatePickerEnd() {
        final JXDatePicker datePicker = new JXDatePicker();
        datePicker.setFormats(DATE_FORMAT);
        datePicker.addActionListener(e -> {
            updateValueLabelEnd();
        });
        datePicker.getEditor().addFocusListener(new FocusListener() {
            @Override
            public void focusGained(final FocusEvent e) {

            }

            @Override
            public void focusLost(final FocusEvent e) {
                // this for some reason does not work properly, so value can not be updated here
            }
        });
        return datePicker;
    }
    private void updateValueLabelEnd() {
        final Date date = _datePicker_end.getDate();
        if (date != null ) {
            _dateStringMap.remove("end");
            _dateStringMap.put("end",simpleDateFormat.format(date));
        }
        if (!_dateStringMap.get(KEY_START).isEmpty()){
            _valueLabel.setText(_dateStringMap.get(KEY_START).concat("||").concat(_dateStringMap.get(KEY_END)));
        }
        fireValueChanged();
    }

    private void createContent() {
        final DCPanel panel = new DCPanel();
        panel.setLayout(new HorizontalLayout(3));
        panel.add(_datePicker_start);
        panel.add(_linkLabel);
        panel.add(_datePicker_end);
        add(panel);
    }

    @Override
    protected void setValue(String value) {
    }

    @Override
    public String getValue() {
        Date datePickerStartDate = _datePicker_start.getDate();
        Date datePickerEndDate = _datePicker_end.getDate();
        if (datePickerStartDate != null && datePickerEndDate!= null){
            return simpleDateFormat.format(datePickerStartDate).concat("||").concat(simpleDateFormat.format(datePickerEndDate));
        }
        return null;
    }
}
