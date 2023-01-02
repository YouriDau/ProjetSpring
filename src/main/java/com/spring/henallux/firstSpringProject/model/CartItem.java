package com.spring.henallux.firstSpringProject.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.text.DecimalFormat;

public class CartItem {
    private Integer id;
    private String name;
    private String description;
    private Double unitPrice;
    private Integer categoryId;
    @Min(value=1)
    @Max(value=999)
    private Integer quantity;

    public CartItem(Integer id, String name, Double unitPrice, String description, Integer categoryId, Integer quantity) {
        setId(id);
        setName(name);
        setDescription(description);
        setUnitPrice(unitPrice);
        setCategoryId(categoryId);
        setQuantity(quantity);
    }

    public CartItem() {}

    public Double getTotal() {
        DecimalFormat df = new DecimalFormat("0.00");
        Double total = quantity * unitPrice;
        String totalStr = df.format(total);
        totalStr = totalStr.replace(",", ".");
        return Double.parseDouble(totalStr);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
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
