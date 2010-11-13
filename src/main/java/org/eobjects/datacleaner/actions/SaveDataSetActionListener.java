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
package org.eobjects.datacleaner.actions;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import org.eobjects.analyzer.data.InputColumn;
import org.eobjects.analyzer.data.InputRow;
import org.eobjects.datacleaner.output.OutputRow;
import org.eobjects.datacleaner.output.OutputWriter;
import org.eobjects.datacleaner.output.csv.CsvOutputWriterFactory;
import org.eobjects.datacleaner.output.datastore.DatastoreOutputWriterFactory;
import org.eobjects.datacleaner.user.UserPreferences;
import org.eobjects.datacleaner.util.FileFilters;

public class SaveDataSetActionListener implements ActionListener {

	private final List<InputColumn<?>> _inputColumns;
	private final InputRow[] _rows;

	public SaveDataSetActionListener(List<InputColumn<?>> inputColumns, InputRow[] rows) {
		_inputColumns = inputColumns;
		_rows = rows;
	}

	private void performWrite(OutputWriter writer) {
		for (InputRow row : _rows) {
			OutputRow outputRow = writer.createRow();
			outputRow.setValues(row);
			outputRow.write();
		}
		writer.close();
	}

	@Override
	public void actionPerformed(final ActionEvent event) {
		JMenuItem saveAsDatastoreItem = new JMenuItem("As datastore");
		saveAsDatastoreItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String datastoreName = JOptionPane.showInputDialog("Datastore name");
				OutputWriter writer = DatastoreOutputWriterFactory.getWriter(datastoreName, _inputColumns);
				performWrite(writer);
			}
		});

		JMenuItem saveAsCsvItem = new JMenuItem("As CSV file");
		saveAsCsvItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser(UserPreferences.getInstance().getAnalysisJobDirectory());
				fileChooser.addChoosableFileFilter(FileFilters.CSV);
				if (fileChooser.showSaveDialog((Component) event.getSource()) == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					if (selectedFile.getName().indexOf('.') == -1) {
						selectedFile = new File(selectedFile.getPath() + ".csv");
					}

					OutputWriter writer = CsvOutputWriterFactory.getWriter(selectedFile.getAbsolutePath(), _inputColumns);
					performWrite(writer);

					File dir = selectedFile.getParentFile();
					UserPreferences.getInstance().setAnalysisJobDirectory(dir);
				}
			}
		});

		JPopupMenu popup = new JPopupMenu();
		popup.add(saveAsDatastoreItem);
		popup.add(saveAsCsvItem);
		JComponent source = (JComponent) event.getSource();
		popup.show(source, 0, source.getHeight());
	}
}
