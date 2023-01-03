package com.spring.henallux.firstSpringProject.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="promotion")
public class PromotionEntity {
    @Id
    @Column(name="id")
    private Integer id;

    @Column(name="start_date")
    private Date startDate;

    @Column(name="end_date")
    private Date endDate;

    @Column(name="percentage")
    private Integer percentage;

    @Column(name="product_id")
    private Integer productId;

    public PromotionEntity(Integer id, Date startDate, Date endDate, Integer percentage, Integer productId) {
        setId(id);
        setStartDate(startDate);
        setEndDate(endDate);
        setPercentage(percentage);
        setProductId(productId);
    }

    public PromotionEntity() {}

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
