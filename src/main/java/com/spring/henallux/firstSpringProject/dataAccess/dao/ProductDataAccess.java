package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.model.Product;

import java.util.ArrayList;

public interface ProductDataAccess {
    ArrayList<Product> findAll();
    Product findByName(String name);
}
