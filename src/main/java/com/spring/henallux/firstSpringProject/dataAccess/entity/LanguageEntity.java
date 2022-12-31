package com.spring.henallux.firstSpringProject.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="language")
public class LanguageEntity {
    @Id
    @Column(name="id")
    private String id;

    public LanguageEntity(String id) {
        setId(id);
    }

    public LanguageEntity(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
