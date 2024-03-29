/**
 * DataCleaner (community edition)
 * Copyright (C) 2014 Free Software Foundation, Inc.
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
package org.datacleaner.windows;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.http.client.utils.URIBuilder;
import org.datacleaner.panels.DCPanel;
import org.datacleaner.util.HdfsUtils;
import org.datacleaner.util.NumberDocument;
import org.datacleaner.util.WidgetFactory;
import org.datacleaner.util.WidgetUtils;
import org.datacleaner.widgets.Alignment;
import org.datacleaner.widgets.DCLabel;
import org.jdesktop.swingx.JXFormattedTextField;
import org.jdesktop.swingx.JXTextField;
import org.jdesktop.swingx.VerticalLayout;

public class HdfsServerAddressDialog extends JComponent {

    private static final long serialVersionUID = 1L;

    private static final int DEFAULT_PORT = 8020;

    private final JXTextField _hostnameField;
    private final JXFormattedTextField _portField;
    private final JButton _okButton;
    private final JButton _cancelButton;

    private URI _serverUri = null;

    public HdfsServerAddressDialog(final String host, final int port) {
        _hostnameField = WidgetFactory.createTextField("hostname", 10);
        if (host == null) {
            _hostnameField.setText("localhost");
        } else {
            _hostnameField.setText(host);
        }

        final NumberFormat integerFormat = NumberFormat.getIntegerInstance();
        integerFormat.setMaximumIntegerDigits(5);
        integerFormat.setMinimumIntegerDigits(1);
        integerFormat.setGroupingUsed(false);
        _portField = WidgetFactory.createFormattedTextField("port", 4, integerFormat);
        _portField.setDocument(new NumberDocument(false, false));
        _portField.setText("" + DEFAULT_PORT);
        if (port == -1) {
            _portField.setText("" + DEFAULT_PORT);
        } else {
            _portField.setText(Integer.toString(port));
        }

        _okButton = new JButton("同意");
        _cancelButton = new JButton("取消");

        setLayout(new VerticalLayout(2));
        final DCPanel propertiesPanel = new DCPanel();
        propertiesPanel.setLayout(new GridBagLayout());
        WidgetUtils.addToGridBag(DCLabel.dark("Hostname: "), propertiesPanel, 0, 0);
        WidgetUtils.addToGridBag(_hostnameField, propertiesPanel, 1, 0, 1, 1, GridBagConstraints.WEST,
                WidgetUtils.DEFAULT_PADDING, 1, 1, GridBagConstraints.HORIZONTAL);
        WidgetUtils.addToGridBag(DCLabel.dark("Port: "), propertiesPanel, 0, 1);
        WidgetUtils.addToGridBag(_portField, propertiesPanel, 1, 1, 1, 1, GridBagConstraints.WEST,
                WidgetUtils.DEFAULT_PADDING, 1, 1, GridBagConstraints.HORIZONTAL);

        add(propertiesPanel);
        add(DCPanel.flow(Alignment.RIGHT, _okButton, _cancelButton));
        setBorder(new EmptyBorder(WidgetUtils.DEFAULT_PADDING, WidgetUtils.DEFAULT_PADDING, WidgetUtils.DEFAULT_PADDING,
                WidgetUtils.DEFAULT_PADDING));
    }

    public static URI showHdfsNameNodeDialog(final JComponent parent, final URI oldUri) {
        String host = null;
        int port = -1;

        if (oldUri != null) {
            host = oldUri.getHost();
            port = oldUri.getPort();
        }

        final HdfsServerAddressDialog serverChoiceDialog = new HdfsServerAddressDialog(host, port);
        final JDialog dialog =
                WidgetFactory.createModalDialog(serverChoiceDialog, parent, "Enter HDFS namenode details", false);
        serverChoiceDialog._okButton.addActionListener(aE -> {
            try {
                final URI uri = new URIBuilder().setScheme(HdfsUrlChooser.HDFS_SCHEME)
                        .setHost(serverChoiceDialog._hostnameField.getText())
                        .setPort(Integer.parseInt(serverChoiceDialog._portField.getText())).setPath("/").build();

                final FileSystem tempFS = HdfsUtils.getFileSystemFromUri(uri);
                tempFS.listStatus(new Path(uri));

                // Let's update the URI
                serverChoiceDialog._serverUri = uri;
                dialog.setVisible(false);

            } catch (URISyntaxException | NumberFormatException e) {
                JOptionPane
                        .showMessageDialog(serverChoiceDialog, "This server address is wrong", "Wrong server address",
                                JOptionPane.ERROR_MESSAGE);
            } catch (final IOException e) {
                // _fileSystem.makeQualified will throw illegal argument is
                // it cannot connect.
                JOptionPane.showMessageDialog(serverChoiceDialog, "This server address is not available",
                        "Server unavailable", JOptionPane.ERROR_MESSAGE);
            }
        });

        serverChoiceDialog._cancelButton.addActionListener(e -> dialog.setVisible(false));

        // Modal, will not return until closed, and will update _uri
        dialog.setVisible(true);
        dialog.dispose();
        return serverChoiceDialog._serverUri;
    }

}
