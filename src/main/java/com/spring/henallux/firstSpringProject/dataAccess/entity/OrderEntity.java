package com.spring.henallux.firstSpringProject.dataAccess.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="`order`")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="`date`")
    private Date date;
    @Column(name="is_paid")
    private Boolean isPaid;
    @Column(name="user_pseudo")
    private String userPseudo;

    public OrderEntity(Integer id, Date date, Boolean isPaid, String userPseudo) {
        setId(id);
        setDate(date);
        setIsPaid(isPaid);
        setUserPseudo(userPseudo);
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

    public Boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Boolean isPaid) {
        this.isPaid = isPaid;
    }

    public String getUserPseudo() {
        return userPseudo;
    }

    public void setUserPseudo(String userPseudo) {
        this.userPseudo = userPseudo;
    }
}
