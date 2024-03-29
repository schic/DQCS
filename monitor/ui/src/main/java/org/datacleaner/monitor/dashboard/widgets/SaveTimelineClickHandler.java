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
package org.datacleaner.monitor.dashboard.widgets;

import org.datacleaner.monitor.dashboard.DashboardServiceAsync;
import org.datacleaner.monitor.dashboard.model.TimelineDefinition;
import org.datacleaner.monitor.dashboard.model.DashboardGroup;
import org.datacleaner.monitor.dashboard.model.TimelineIdentifier;
import org.datacleaner.monitor.shared.model.TenantIdentifier;
import org.datacleaner.monitor.util.DCAsyncCallback;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;

/**
 * Click handler invoked when the user clicks the "Save timeline" button.
 */
public class SaveTimelineClickHandler implements ClickHandler {

    private final DashboardServiceAsync _service;
    private final TenantIdentifier _tenantIdentifier;
    private final TimelinePanel _timelinePanel;

    public SaveTimelineClickHandler(DashboardServiceAsync service, TenantIdentifier tenantIdentifier, TimelinePanel timelinePanel) {
        _service = service;
        _tenantIdentifier = tenantIdentifier;
        _timelinePanel = timelinePanel;
    }

    @Override
    public void onClick(ClickEvent event) {
        final boolean create;
        TimelineIdentifier timelineIdentifier = _timelinePanel.getTimelineIdentifier();
        if (timelineIdentifier == null) {
            final String name = Window.prompt("时间曲线名称", "");
            if (name == null || name.trim().length() == 0) {
                GWT.log("不是有效的时间曲线名称：" + name);
                _timelinePanel.setTimelineDefinitionChanged();
                return;
            }
            final DashboardGroup timelineGroup = _timelinePanel.getTimelineGroupPanel().getTimelineGroup();
            timelineIdentifier = new TimelineIdentifier(name, null, timelineGroup);
            create = true;
        } else {
            create = false;
        }
        TimelineDefinition timelineDefinition = _timelinePanel.getTimelineDefinition();

        _timelinePanel.setTimelineDefinitionUnchanged();
        
        if (create) {
            _service.createTimelineDefinition(_tenantIdentifier, timelineIdentifier, timelineDefinition,
                    new DCAsyncCallback<TimelineIdentifier>() {
                        @Override
                        public void onSuccess(TimelineIdentifier result) {
                            _timelinePanel.setTimelineIdentifier(result);
                            Window.alert("已保存时间曲线 '" + result.getName() + "'");
                        }
                    });
        } else {
            _service.updateTimelineDefinition(_tenantIdentifier, timelineIdentifier, timelineDefinition,
                    new DCAsyncCallback<TimelineIdentifier>() {
                        @Override
                        public void onSuccess(TimelineIdentifier result) {
                            Window.alert("已保存时间曲线 '" + result.getName() + "'");
                        }
                    });
        }
    }

}
