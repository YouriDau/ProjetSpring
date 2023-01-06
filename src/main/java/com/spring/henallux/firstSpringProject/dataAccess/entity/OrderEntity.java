package com.spring.henallux.firstSpringProject.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="order")
public class OrderEntity {
    @Id
    @Column(name="id")
    private Integer id;
    @Column(name="date")
    private Date date;
    @Column(name="is_paid")
    private Boolean isPaid;

    public OrderEntity(Integer id, Date date, Boolean isPaid) {
        setId(id);
        setDate(date);
        setIsPaid(isPaid);
    }

    public OrderEntity(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean setIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Boolean isPaid) {
        isPaid = isPaid;
    }
}
