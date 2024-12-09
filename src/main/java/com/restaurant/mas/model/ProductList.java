package com.restaurant.mas.model;

import java.util.List;

public class ProductList {
    private List<Product> products;

    public boolean checkIngredients(int dishId) {
        return true;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
