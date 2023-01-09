package com.spring.henallux.firstSpringProject.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductTest {
    private Product product;

    @Before
    public void setUp() throws Exception {
        product = new Product();
    }

    @Test
    public void testGetPriceWithPromo() {
        Promotion promotion = new Promotion();
        promotion.setPercentage(10);
        Product product = new Product();
        product.setUnitPrice(20.00);
        product.setPromotion(promotion);

        Double result = product.getPriceWithPromo();

        Double expectedPrice = 18.00;
        assertEquals(expectedPrice, result);
    }

    @Test
    public void testGetPromotionAmount() {
        assertEquals(1, product.getPromotionAmount(10, 10), 0.01);
    }
}