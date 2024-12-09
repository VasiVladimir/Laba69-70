package com.restaurant.mas.model;

public class Dish {
    private int menuDishId;
    private int menuDishCard;
    private double menuDishPrice;
    private boolean menuDishActive;


    public int getMenuDishId() {
        return menuDishId;
    }

    public void setMenuDishId(int menuDishId) {
        this.menuDishId = menuDishId;
    }

    public int getMenuDishCard() {
        return menuDishCard;
    }

    public void setMenuDishCard(int menuDishCard) {
        this.menuDishCard = menuDishCard;
    }

    public double getMenuDishPrice() {
        return menuDishPrice;
    }

    public void setMenuDishPrice(double menuDishPrice) {
        this.menuDishPrice = menuDishPrice;
    }

    public boolean isMenuDishActive() {
        return menuDishActive;
    }

    public void setMenuDishActive(boolean menuDishActive) {
        this.menuDishActive = menuDishActive;
    }
}
