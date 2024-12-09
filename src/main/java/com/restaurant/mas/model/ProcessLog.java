package com.restaurant.mas.model;

import java.util.ArrayList;
import java.util.List;

public class ProcessLog {
    private List<ProcessEntry> processEntries = new ArrayList<>();

    public void addProcessEntry(ProcessEntry entry) {
        processEntries.add(entry);
    }

    public List<ProcessEntry> getProcessEntries() {
        return processEntries;
    }
}
