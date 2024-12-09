package com.restaurant.mas.model;

public class Product {
    private int prodTypeId;
    private String prodTypeName;
    private boolean prodIsFood;


    public int getProdTypeId() {
        return prodTypeId;
    }

    public void setProdTypeId(int prodTypeId) {
        this.prodTypeId = prodTypeId;
    }

    public String getProdTypeName() {
        return prodTypeName;
    }

    public void setProdTypeName(String prodTypeName) {
        this.prodTypeName = prodTypeName;
    }

    public boolean isProdIsFood() {
        return prodIsFood;
    }

    public void setProdIsFood(boolean prodIsFood) {
        this.prodIsFood = prodIsFood;
    }
}
