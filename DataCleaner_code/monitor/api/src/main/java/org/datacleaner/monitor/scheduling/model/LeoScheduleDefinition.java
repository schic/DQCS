package org.datacleaner.monitor.scheduling.model;

import java.io.Serializable;

public class LeoScheduleDefinition implements Comparable<LeoScheduleDefinition>, Serializable {

    private static final long serialVersionUID = 1L;
    private String _cronExpression;
    private String triggerKeyGroup;
    private String triggerKeyName;

    public LeoScheduleDefinition() {
        _cronExpression = "0 8,18,28,38,48,58 * * * ?";
        triggerKeyGroup = "Leo创建任务列表";
        triggerKeyName = "Leo创建json数据";
    }

    public LeoScheduleDefinition(String _cronExpression, String _groupName) {
        this._cronExpression = _cronExpression;
        this.triggerKeyGroup = _groupName;
        this.triggerKeyName = _groupName;
    }

    public String get_cronExpression() {
        return _cronExpression;
    }

    public void set_cronExpression(String _cronExpression) {
        this._cronExpression = _cronExpression;
    }

    public String getTriggerKeyGroup() {
        return triggerKeyGroup;
    }

    public void setTriggerKeyGroup(String triggerKeyGroup) {
        this.triggerKeyGroup = triggerKeyGroup;
    }

    public String getTriggerKeyName() {
        return triggerKeyName;
    }

    public void setTriggerKeyName(String triggerKeyName) {
        this.triggerKeyName = triggerKeyName;
    }

    @Override
    public int compareTo(LeoScheduleDefinition o) {
        return 0;
    }
}
