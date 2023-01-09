package com.spring.henallux.firstSpringProject.model;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.text.DecimalFormat;

public class Product {
    private Integer id;
    @NotNull
    @Size(max=150)
    private String name;
    @NotNull
    @Size(max=150)
    private String description;
    @NotNull
    @Min(0)
    private Double unitPrice;
    @NotNull
    private Integer categoryId;

    private Promotion promotion;

    public Product(Integer id, String name, String description, Double unitPrice, Integer categoryId) {
        setId(id);
        setName(name);
        setDescription(description);
        setUnitPrice(unitPrice);
        setCategoryId(categoryId);
        setPromotion(null);
    }

    public Product(){}

    public Double getPriceWithPromo() {
        if (promotion != null) {
            Double total = (unitPrice - getPromotionAmount(promotion.getPercentage(), unitPrice));
            return total;
        } else {
            return unitPrice;
        }
    }

    public Double getPromotionAmount(int promotion, double unitPrice) {
        DecimalFormat df = new DecimalFormat("0.00");
        Double total = ((double)promotion / 100) * unitPrice;
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

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }
}
