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
package org.datacleaner.monitor.referencedata.widgets;

import java.util.Set;

import org.datacleaner.monitor.referencedata.ReferenceDataItem;
import org.datacleaner.monitor.referencedata.ReferenceDataService;
import org.datacleaner.monitor.referencedata.ReferenceDataServiceAsync;
import org.datacleaner.monitor.shared.model.TenantIdentifier;
import org.datacleaner.monitor.shared.widgets.CancelPopupButton;
import org.datacleaner.monitor.shared.widgets.DCButtons;
import org.datacleaner.monitor.shared.widgets.DCPopupPanel;
import org.datacleaner.monitor.util.DCAsyncCallback;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ListWidget extends VerticalPanel {
    private final TenantIdentifier _tenant;
    private int _counter = 0;
    
    public ListWidget(TenantIdentifier tenant, Set<ReferenceDataItem> set) {
        _tenant = tenant;
        
        for (ReferenceDataItem item : set) {
            add(createLine(item.getType(), item.getName()));
        }
    }

    private HorizontalPanel createLine(final ReferenceDataItem.Type itemType, final String itemName) {
        _counter++;
        final HorizontalPanel line = new HorizontalPanel();
        final String oddEvenClass = (_counter % 2 == 0) ? "even" : "odd";
        line.addStyleName(oddEvenClass);
        line.add(createNameLabel(itemName));
        line.add(createRemoveButton(itemType, itemName));
        
        return line;
    }

    private Label createNameLabel(final String itemName) {
        return new Label(itemName);
    }

    private Button createRemoveButton(final ReferenceDataItem.Type itemType, final String itemName) {
        final Button button = new Button("删除");
        button.removeStyleName("gwt-Button");
        button.addStyleName("glyphicon glyphicon-minus btn btn-sm btn-danger");
        button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent clickEvent) {
                final DCPopupPanel popup = new DCPopupPanel("确定要删除 '" + itemName + "' 吗?");
                popup.addButton(new CancelPopupButton(popup));
                Button okButton = DCButtons.primaryButton(null, "确定");
                okButton.addClickHandler(new ClickHandler() {
                    @Override
                    public void onClick(ClickEvent clickEvent) {
                        final ReferenceDataServiceAsync service = GWT.create(ReferenceDataService.class);
                        service.removeItem(_tenant, itemType, itemName, new DCAsyncCallback<Boolean>() {
                            @Override
                            public void onSuccess(final Boolean removedSuccessfully) {
                                if (removedSuccessfully) {
                                    Window.Location.reload();
                                } else {
                                    Window.alert(itemName + " 未删除。 ");
                                }
                            }
                        });
                    }
                });
                popup.addButton(okButton);
                popup.center();
                popup.show();
//                if (Window.confirm("确定要删除 '" + itemName + "' 吗?")) {
//                    final ReferenceDataServiceAsync service = GWT.create(ReferenceDataService.class);
//                    service.removeItem(_tenant, itemType, itemName, new DCAsyncCallback<Boolean>() {
//                        @Override
//                        public void onSuccess(final Boolean removedSuccessfully) {
//                            if (removedSuccessfully) {
//                                Window.Location.reload();
//                            } else {
//                                Window.alert(itemName + " 未删除。 ");
//                            }
//                        }
//                    });
//                }
            }
        });

        return button;
    }
}
