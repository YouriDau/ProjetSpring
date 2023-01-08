package com.spring.henallux.firstSpringProject.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name="order_line")
public class OrderLineEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="quantity")
    private Integer quantity;
    @Column(name="unit_price")
    private Double unitPrice;
    @Column(name="order_id")
    private Integer orderId;
    @Column(name="product_id")
    private Integer productId;

    public OrderLineEntity(Integer id, Integer quantity, Double unitPrice, Integer orderId, Integer productId) {
        setId(id);
        setQuantity(quantity);
        setUnitPrice(unitPrice);
        setOrderId(orderId);
        setProductId(productId);
    }

    public OrderLineEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
