package com.spring.henallux.firstSpringProject.dataAccess.dao;


import com.spring.henallux.firstSpringProject.model.Order;

public interface OrderDataAccess {
    void saveOrder(Order order);

    public void updateOrderIsPaid(boolean isPaid, String username);
}
