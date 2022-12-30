package com.spring.henallux.firstSpringProject.model;

import java.util.HashMap;

public class Cart {
    private HashMap<String, CartItem> items;

    public Cart() {
        items = new HashMap<>();
    }

    public HashMap<String, CartItem> getItems() {
        return items;
    }

    public void addItem(CartItem item) {
        if (!items.containsKey(item.getName())) {
            items.put(item.getName(), item);
        } else {
            items.get(item.getName()).addQuantity(item.getQuantity());
        }
    }
}
