package org.datacleaner.monitor.scheduling.model;

import groovy.json.StringEscapeUtils;

import java.io.Serializable;

public class LeoExecutionData implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String resultId;
    private String beginTime;
    private String endTime;
    private String status;
    private String cost;
    private String url;
    private String triggerType;
    private String triggerBy;
    private String logOutput;

    public LeoExecutionData() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResultId() {
        return resultId;
    }

    public void setResultId(String resultId) {
        this.resultId = resultId;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTriggerType() {
        return triggerType;
    }

    public void setTriggerType(String triggerType) {
        this.triggerType = triggerType;
    }

    public String getTriggerBy() {
        return triggerBy;
    }

    public void setTriggerBy(String triggerBy) {
        this.triggerBy = triggerBy;
    }

    public String getLogOutput() {
        return logOutput;
    }

    public void setLogOutput(String logOutput) {
        this.logOutput = logOutput;
    }

    @Override
    public String toString() {
        return "{\n" +
                "   \"name\": \""+name+"\",\n" +
                "   \"resultId\": \""+resultId+"\",\n" +
                "   \"beginTime\": \""+beginTime+"\",\n" +
                "   \"endTime\": \""+endTime+"\",\n" +
                "   \"status\": \""+status+"\",\n" +
                "   \"cost\": \""+cost+"\",\n" +
                "   \"url\": \""+url+"\",\n" +
                "   \"triggerType\": \""+triggerType+"\",\n" +
                "   \"triggerBy\": \""+triggerBy+"\",\n" +
                "   \"logOutput\": \""+ StringEscapeUtils.escapeJava(logOutput)+"\"\n" +
                "}";
    }
}
