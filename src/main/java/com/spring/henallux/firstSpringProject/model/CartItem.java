package com.spring.henallux.firstSpringProject.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.text.DecimalFormat;

public class CartItem {
    private Product product;
    @Min(value=1)
    @Max(value=999)
    private Integer quantity;

    public CartItem(Product product, Integer quantity) {
        setProduct(product);
        setQuantity(quantity);
    }

    public CartItem() {}

    public Double getTotal() {
        DecimalFormat df = new DecimalFormat("0.00");
        Double total = quantity * product.getUnitPrice();
        String totalStr = df.format(total);
        totalStr = totalStr.replace(",", ".");
        return Double.parseDouble(totalStr);
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void addQuantity(Integer quantity) {
        this.quantity += quantity;
    }
}
