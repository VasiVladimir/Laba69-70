package com.restaurant.mas.model;

public class Equipment {
    private int equipType;
    private String equipName;
    private boolean equipActive;


    public int getEquipType() {
        return equipType;
    }

    public void setEquipType(int equipType) {
        this.equipType = equipType;
    }

    public String getEquipName() {
        return equipName;
    }

    public void setEquipName(String equipName) {
        this.equipName = equipName;
    }

    public boolean isEquipActive() {
        return equipActive;
    }

    public void setEquipActive(boolean equipActive) {
        this.equipActive = equipActive;
    }
}
