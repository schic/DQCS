package org.datacleaner.panels.jleo;

import org.apache.metamodel.schema.Column;
import org.apache.metamodel.schema.MutableColumn;
import org.apache.metamodel.schema.Table;
import org.apache.metamodel.util.EqualsBuilder;
import org.apache.metamodel.util.MutableRef;
import org.datacleaner.descriptors.ConfiguredPropertyDescriptor;
import org.datacleaner.job.builder.ComponentBuilder;
import org.datacleaner.panels.DCPanel;
import org.datacleaner.widgets.DCComboBox;
import org.datacleaner.widgets.SourceColumnComboBox;
import org.datacleaner.widgets.properties.AbstractPropertyWidget;
import org.jdesktop.swingx.VerticalLayout;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description 从附表中选择一个日期字段  以便附表不用全表查询
 * @Author LeoDY
 * @Date 2021/3/31
 **/
public class JLeoLookupDateColumnsPropertyWidget extends AbstractPropertyWidget<String[]> {

    private final List<SourceColumnComboBox> _comboBoxes;
    private final MutableRef<Table> _tableRef;
    private final DCPanel _comboBoxPanel;

    public JLeoLookupDateColumnsPropertyWidget(final ComponentBuilder componentBuilder,
                                               final ConfiguredPropertyDescriptor propertyDescriptor) {
        super(componentBuilder, propertyDescriptor);
        _comboBoxes = new ArrayList<>();

        _tableRef = new MutableRef<>();

        _comboBoxPanel = new DCPanel();
        _comboBoxPanel.setLayout(new VerticalLayout(2));

        final DCPanel outerPanel = new DCPanel();
        outerPanel.setLayout(new BorderLayout());

        outerPanel.add(_comboBoxPanel, BorderLayout.WEST);

        add(outerPanel);

        final String[] currentValue = getCurrentValue();//这里获取到的就是propertyDescriptor的值，也就是Output columns属性的值
        setValue(currentValue);
    }


    public void setTable(final Table table) {
        _tableRef.set(table);//该类的widget小部件指什么小部件？这里把选中的数据表给 _tableRef
        for (final SourceColumnComboBox comboBox : _comboBoxes) {
            comboBox.setModel(table);//同时也把选中的数据表给  _comboBoxes
        }
    }

    @Override
    public String[] getValue() {
        final List<String> result = new ArrayList<>();
        for (final SourceColumnComboBox comboBox : _comboBoxes) {
            final Column column = comboBox.getSelectedItem();
            if (column != null) {
                result.add(column.getName());
            }
        }
        return result.toArray(new String[result.size()]);
    }

    @Override
    protected void setValue(String[] values) {
        if (values == null || values.length == 0) {
            values = new String[1];
        }
        final String[] previousValues = getValue();
        if (!EqualsBuilder.equals(values, previousValues)) {
            for (int i = 0; i < Math.min(previousValues.length, values.length); i++) {
                // modify combo boxes 修改组合框
                if (!EqualsBuilder.equals(previousValues[i], values[i])) {
                    final SourceColumnComboBox comboBox = _comboBoxes.get(i);
                    comboBox.setEditable(true);
                    comboBox.setSelectedItem(values[i]);
                    comboBox.setEditable(false);
                }
            }
            while (_comboBoxes.size() < values.length) {
                // add combo boxes if there are too few 如果组合框太少，请添加组合框
                final String nextValue = values[_comboBoxes.size()];
                addComboBox(nextValue, false);
            }
            while (_comboBoxes.size() > values.length) {
                // remove text boxes if there are too many
                //removeComboBox();
            }
            _comboBoxPanel.updateUI();
        }
    }

    protected void addComboBox(final String value, final boolean updateUI) {
        final SourceColumnComboBox comboBox = new SourceColumnComboBox();
        final Column column;
        final Table table = _tableRef.get();
        if (value == null) {
            column = null;
        } else if (table == null) {
            column = new MutableColumn(value);
        } else {
            column = table.getColumnByName(value);
        }
        comboBox.setModel(table);

        comboBox.setEditable(true);
        comboBox.setSelectedItem(column);
        comboBox.setEditable(false);
        comboBox.addColumnSelectedListener(item -> fireValueChanged());

        _comboBoxes.add(comboBox);
        _comboBoxPanel.add(comboBox);

        if (updateUI) {
            _comboBoxPanel.updateUI();
        }
    }

    //public void addVisitableListener(final DCComboBox.Listener<Table> listener) {
    //    for (final SourceColumnComboBox comboBox : _comboBoxes) {
    //        comboBox.addListener(item -> fireValueChanged());
    //    }
    //}
    //public void addListener(final DCComboBox.Listener<Table> listener) {
    //    _listeners.add(listener);
    //}

}
