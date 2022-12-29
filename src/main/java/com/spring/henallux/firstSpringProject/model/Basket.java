package com.spring.henallux.firstSpringProject.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Basket {
    private ArrayList<Product> items;

    public Basket() {
        items = new ArrayList<>();
    }

    public ArrayList<Product> getItems() {
        return items;
    }

    public void setItems(ArrayList<Product> items) {
        this.items = items;
    }
}
