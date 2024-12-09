package com.restaurant.mas.model;

import java.util.List;

public class VisitorOrder {
    private String visName;
    private String visOrdStarted;
    private String visOrdEnded;
    private double visOrdTotal;
    private List<OrderDish> visOrdDishes;

    public static class OrderDish {
        private int ordDishId;
        private int menuDish;

        public int getOrdDishId() {
            return ordDishId;
        }

        public void setOrdDishId(int ordDishId) {
            this.ordDishId = ordDishId;
        }

        public int getMenuDish() {
            return menuDish;
        }

        public void setMenuDish(int menuDish) {
            this.menuDish = menuDish;
        }
    }

    public String getVisName() {
        return visName;
    }

    public void setVisName(String visName) {
        this.visName = visName;
    }

    public String getVisOrdStarted() {
        return visOrdStarted;
    }

    public void setVisOrdStarted(String visOrdStarted) {
        this.visOrdStarted = visOrdStarted;
    }

    public String getVisOrdEnded() {
        return visOrdEnded;
    }

    public void setVisOrdEnded(String visOrdEnded) {
        this.visOrdEnded = visOrdEnded;
    }

    public double getVisOrdTotal() {
        return visOrdTotal;
    }

    public void setVisOrdTotal(double visOrdTotal) {
        this.visOrdTotal = visOrdTotal;
    }

    public List<OrderDish> getVisOrdDishes() {
        return visOrdDishes;
    }

    public void setVisOrdDishes(List<OrderDish> visOrdDishes) {
        this.visOrdDishes = visOrdDishes;
    }
}
