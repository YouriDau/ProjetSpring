package com.spring.henallux.firstSpringProject.model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Order {
    private Integer id;
    private Date date;
    private Boolean isPaid;
    private String userPseudo;

    public Order(Integer id, Date date, Boolean isPaid, String userPseudo) {
        setId(id);
        setDate(date);
        setIsPaid(isPaid);
        setUserPseudo(userPseudo);
    }

    public Order() {
        setIsPaid(false);
        setDate(new Date());
    }

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
