package com.restaurant.mas.model;

public class LogEntry {
    private String processName;
    private String cookName;
    private String status;

    public LogEntry(String processName, String cookName, String status) {
        this.processName = processName;
        this.cookName = cookName;
        this.status = status;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getCookName() {
        return cookName;
    }

    public void setCookName(String cookName) {
        this.cookName = cookName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
