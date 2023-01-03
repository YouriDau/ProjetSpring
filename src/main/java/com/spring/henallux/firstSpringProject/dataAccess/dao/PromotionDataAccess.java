package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.model.Promotion;

public interface PromotionDataAccess {
    Promotion findByProductId(Integer productId);
}
