package org.datacleaner.panels.jleo;

import org.apache.metamodel.schema.Column;
import org.apache.metamodel.schema.MutableColumn;
import org.apache.metamodel.schema.Table;
import org.apache.metamodel.util.EqualsBuilder;
import org.apache.metamodel.util.MutableRef;
import org.datacleaner.descriptors.ConfiguredPropertyDescriptor;
import org.datacleaner.job.builder.ComponentBuilder;
import org.datacleaner.panels.DCPanel;
import org.datacleaner.util.IconUtils;
import org.datacleaner.util.WidgetFactory;
import org.datacleaner.widgets.SourceColumnComboBox;
import org.datacleaner.widgets.properties.AbstractPropertyWidget;
import org.jdesktop.swingx.VerticalLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description 该类是
 * @Author LeoDY
 * @Date 2021/3/29
 **/
public class JLeoLookupOutputColumnsPropertyWidget extends AbstractPropertyWidget<String[]> {

    private final List<SourceColumnComboBox> _comboBoxes;
    private final MutableRef<Table> _tableRef;
    private final DCPanel _comboBoxPanel;

    public JLeoLookupOutputColumnsPropertyWidget(final ComponentBuilder componentBuilder,
                                                 final ConfiguredPropertyDescriptor propertyDescriptor) {
        super(componentBuilder, propertyDescriptor);
        _comboBoxes = new ArrayList<>();

        _tableRef = new MutableRef<>();

        _comboBoxPanel = new DCPanel();
        _comboBoxPanel.setLayout(new VerticalLayout(2));

        final JButton addButton = WidgetFactory.createSmallButton(IconUtils.ACTION_ADD_DARK);
        addButton.addActionListener(e -> {
            addComboBox(null, true);
            fireValueChanged();
        });

        final JButton removeButton = WidgetFactory.createSmallButton(IconUtils.ACTION_REMOVE_DARK);
        removeButton.addActionListener(e -> {
            final int componentCount = _comboBoxPanel.getComponentCount();
            if (componentCount > 0) {
                removeComboBox();
                _comboBoxPanel.updateUI();
                fireValueChanged();
            }
        });

        final DCPanel buttonPanel = new DCPanel();
        buttonPanel.setBorder(new EmptyBorder(0, 4, 0, 0));
        buttonPanel.setLayout(new VerticalLayout(2));
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);

        final DCPanel outerPanel = new DCPanel();
        outerPanel.setLayout(new BorderLayout());

        outerPanel.add(_comboBoxPanel, BorderLayout.CENTER);
        outerPanel.add(buttonPanel, BorderLayout.EAST);

        add(outerPanel);

        final String[] currentValue = getCurrentValue();//这里获取到的就是propertyDescriptor的值，也就是Output columns属性的值
        setValue(currentValue);
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

    public void setTable(final Table table) {
        _tableRef.set(table);//该类的widget小部件 这里把选中的数据表给 _tableRef
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
                // modify combo boxes
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
                removeComboBox();
            }
            _comboBoxPanel.updateUI();
        }
    }

    private void removeComboBox() {
        final int comboBoxIndex = _comboBoxes.size() - 1;
        _comboBoxes.remove(comboBoxIndex);
        _comboBoxPanel.remove(comboBoxIndex);
    }
}
