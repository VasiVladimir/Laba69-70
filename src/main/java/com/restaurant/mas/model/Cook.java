package com.restaurant.mas.model;

public class Cook {
    private int cookId;
    private String cookName;
    private boolean cookActive;


    public int getCookId() {
        return cookId;
    }

    public void setCookId(int cookId) {
        this.cookId = cookId;
    }

    public String getCookName() {
        return cookName;
    }

    public void setCookName(String cookName) {
        this.cookName = cookName;
    }

    public boolean isCookActive() {
        return cookActive;
    }

    public void setCookActive(boolean cookActive) {
        this.cookActive = cookActive;
    }
}
