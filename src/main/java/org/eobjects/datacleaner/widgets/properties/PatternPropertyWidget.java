/**
 * eobjects.org DataCleaner
 * Copyright (C) 2010 eobjects.org
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
package org.eobjects.datacleaner.widgets.properties;

import java.awt.Color;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.eobjects.analyzer.descriptors.ConfiguredPropertyDescriptor;
import org.eobjects.analyzer.job.builder.AbstractBeanJobBuilder;
import org.eobjects.datacleaner.util.DCDocumentListener;
import org.eobjects.datacleaner.util.WidgetUtils;
import org.jdesktop.swingx.JXTextField;

public class PatternPropertyWidget extends AbstractPropertyWidget<Pattern> implements DocumentListener {

	private static final long serialVersionUID = 1L;

	private final JXTextField _textField;

	public PatternPropertyWidget(ConfiguredPropertyDescriptor propertyDescriptor,
			AbstractBeanJobBuilder<?, ?, ?> beanJobBuilder) {
		super(beanJobBuilder, propertyDescriptor);
		_textField = WidgetUtils.createTextField(propertyDescriptor.getName());
		_textField.getDocument().addDocumentListener(this);
		String currentValue = (String) beanJobBuilder.getConfiguredProperty(propertyDescriptor);
		if (currentValue != null) {
			_textField.setText(currentValue);
		}
		_textField.getDocument().addDocumentListener(new DCDocumentListener() {
			@Override
			protected void onChange(DocumentEvent e) {
				fireValueChanged();
			}
		});
		updateColor();
		add(_textField);
	}

	@Override
	public boolean isSet() {
		return _textField.getText() != null && _textField.getText().length() > 0 && isValidPattern();
	}

	@Override
	public Pattern getValue() {
		try {
			return Pattern.compile(_textField.getText());
		} catch (PatternSyntaxException e) {
			return null;
		}
	}

	public boolean isValidPattern() {
		try {
			Pattern.compile(_textField.getText());
		} catch (PatternSyntaxException e) {
			return false;
		}
		return true;
	}

	private void updateColor() {
		if (_textField.getText() == null || _textField.getText().length() == 0) {
			_textField.setBackground(Color.white);
		} else if (isValidPattern()) {
			_textField.setBackground(Color.green);
		} else {
			_textField.setBackground(Color.red);
		}
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		updateColor();
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		updateColor();
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		updateColor();
	}
	
	@Override
	protected void setValue(Pattern value) {
		_textField.setText(value.pattern());
	}
}