/**
 * DataCleaner (community edition)
 * Copyright (C) 2014 Neopost - Customer Information Management
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
package org.datacleaner.monitor.query.widgets;

import java.util.List;

import org.datacleaner.monitor.shared.DatastoreServiceAsync;
import org.datacleaner.monitor.shared.model.DatastoreIdentifier;
import org.datacleaner.monitor.shared.model.SchemaIdentifier;
import org.datacleaner.monitor.shared.model.TableIdentifier;
import org.datacleaner.monitor.shared.model.TenantIdentifier;
import org.datacleaner.monitor.shared.widgets.DCButtons;
import org.datacleaner.monitor.shared.widgets.HeadingLabel;
import org.datacleaner.monitor.shared.widgets.LoadingIndicator;
import org.datacleaner.monitor.shared.widgets.SchemaTree;
import org.datacleaner.monitor.util.DCRequestBuilder;
import org.datacleaner.monitor.util.DCRequestCallback;
import org.datacleaner.monitor.util.ErrorHandler;
import org.datacleaner.monitor.util.Urls;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TreeItem;

/**
 * Main panel of the query module - contains the text area for the query, the
 * button to fire it and the area for the resulting table view.
 */
public class QueryPanel extends FlowPanel {

    private final TextArea _queryTextArea;
    private final DatastoreIdentifier _datastore;
    private final TenantIdentifier _tenant;
    private final Button _executeQueryButton;
    private final HTML _resultPanel;
    private final LoadingIndicator _loadingIcon;

    public QueryPanel(TenantIdentifier tenant, DatastoreServiceAsync service, DatastoreIdentifier datastore,
            SchemaIdentifier schema, List<TableIdentifier> tables) {
        super();
        setStyleName("QueryPanel");

        _tenant = tenant;
        _datastore = datastore;
        _queryTextArea = new TextArea();
        _queryTextArea.setStyleName("form-control");
        _queryTextArea.setHeight("6.5em");

        if (tables.isEmpty()) {
            writeQuery(null);
        } else {
            writeQuery(tables.get(0));

        }

        _executeQueryButton = DCButtons.primaryButton(null, "确定");
        _executeQueryButton.addStyleName("btn-block");

        _loadingIcon = new LoadingIndicator();
        _loadingIcon.setVisible(false);
        _resultPanel = new HTML();
        _resultPanel.addStyleName("QueryResultPanel");

        final String url = Urls.createRepositoryUrl(_tenant, "datastores/" + _datastore.getName() + ".query");

        _executeQueryButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                final DCRequestBuilder requestBuilder = new DCRequestBuilder(RequestBuilder.POST, url);
                final String query = getCurrentQuery();
                _resultPanel.setVisible(false);
                _loadingIcon.setVisible(true);
                requestBuilder.send(query, new DCRequestCallback() {
                    @Override
                    protected void onSuccess(Request request, Response response) {
                        final String resultText = response.getText();
                        _resultPanel.setHTML(resultText);
                        _resultPanel.setVisible(true);
                    }

                    @Override
                    public void onResponseReceived(Request request, Response response) {
                        _loadingIcon.setVisible(false);
                        if (response.getStatusCode() == 400) {
                            ErrorHandler.showErrorDialog("无法处理查询!", response.getStatusText(),
                                    (String) null);
                            return;
                        }
                        super.onResponseReceived(request, response);
                    }
                });
            }
        });

        final SchemaTree schemaPanel = new SchemaTree(_tenant, _datastore, service);
        schemaPanel.addSelectionHandler(new SelectionHandler<TreeItem>() {
            @Override
            public void onSelection(SelectionEvent<TreeItem> event) {
                TreeItem selectedItem = event.getSelectedItem();
                if (selectedItem.getUserObject() instanceof TableIdentifier) {
                    writeQuery((TableIdentifier) selectedItem.getUserObject());
                }
            }
        });

        add(schemaPanel);
        add(new HeadingLabel("查询数据存储: " + _datastore.getName()));
        add(new Label("请填写下面的查询语句并单击“确定”按钮在服务器上执行。"));

        final FlowPanel buttonPanel = new FlowPanel();
        buttonPanel.add(_queryTextArea);;
        buttonPanel.add(_executeQueryButton);

        add(buttonPanel);
        add(_loadingIcon);
        add(_resultPanel);
    }

    protected void writeQuery(TableIdentifier table) {
        if (table == null) {
            _queryTextArea.setText("SELECT *\nFROM [table] \nLIMIT 50");
        } else {
            _queryTextArea.setText("SELECT *\nFROM " + table.getSchema().getName() + "." + table.getName()
                    + "\nLIMIT 50");
        }
    }

    private String getCurrentQuery() {
        String query = _queryTextArea.getText();
        query = query.trim();
        query = query.replaceAll("\r", " ");
        query = query.replaceAll("\n", " ");
        return query;
    }

}
