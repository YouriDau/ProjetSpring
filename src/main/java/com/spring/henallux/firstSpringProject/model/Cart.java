package com.spring.henallux.firstSpringProject.model;

import java.text.DecimalFormat;
import java.util.HashMap;

public class Cart {
    private HashMap<String, CartItem> items;

    public Cart() {
        items = new HashMap<>();
    }

    public HashMap<String, CartItem> getItems() {
        return items;
    }

    public CartItem getItem(String name) {
        return items.get(name);
    }

    public void addItem(CartItem item) {
        if (!items.containsKey(item.getProduct().getName())) {
            items.put(item.getProduct().getName(), item);
        } else {
            items.get(item.getProduct().getName()).addQuantity(item.getQuantity());
        }
    }

    public Double getTotalPrice() {
        DecimalFormat df = new DecimalFormat("0.00");
        double total = 0;
        for(CartItem item : items.values()) {
            total += item.getTotal();
        }
        String totalStr = df.format(total);
        totalStr = totalStr.replace(",", ".");
        return Double.parseDouble(totalStr);
    }
}
