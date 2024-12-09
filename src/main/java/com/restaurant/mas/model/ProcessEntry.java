package com.restaurant.mas.model;

public class ProcessEntry {
    private String processName;
    private long startTime;
    private long endTime;

    public ProcessEntry(String processName, long startTime, long endTime) {
        this.processName = processName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getProcessName() {
        return processName;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }
}
