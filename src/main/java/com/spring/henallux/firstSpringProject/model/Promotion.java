package com.spring.henallux.firstSpringProject.model;

import java.util.Date;

public class Promotion {
    private Integer id;
    private Date startDate;
    private Date endDate;
    private Integer percentage;
    private Integer productId;

    public Promotion(Integer id, Date startDate, Date endDate, Integer percentage, Integer productId) {
        setId(id);
        setStartDate(startDate);
        setEndDate(endDate);
        setPercentage(percentage);
        setProductId(productId);
    }

    public Promotion() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
