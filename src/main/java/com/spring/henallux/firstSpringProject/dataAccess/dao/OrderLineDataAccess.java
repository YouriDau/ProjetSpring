package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.model.CartItem;

import java.util.ArrayList;

public interface OrderLineDataAccess {
    void saveCartItems(ArrayList<CartItem> items, String username);
}
