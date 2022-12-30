package com.spring.henallux.firstSpringProject.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Basket {
    private HashMap<Integer, Product> items;

    public Basket() {
        items = new HashMap<>();
    }

    public HashMap<Integer, Product> getItems() {
        return items;
    }

    public void addItem(Product item) {
        if (!items.containsKey(item.getName())) {
            items.put(item.getId(), item);
        }
    }
}
