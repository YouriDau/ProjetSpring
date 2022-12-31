package com.spring.henallux.firstSpringProject.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="translation")
public class TranslationEntity {
    @Id
    @Column(name="id")
    private Integer id;
    @Column(name="label")
    private String label;
    @Column(name="category_id")
    private Integer categoryId;
    @Column(name="language_id")
    private String languageId;

    public TranslationEntity(Integer id, String label, Integer categoryId, String languageId) {
        setId(id);
        setLabel(label);
        setCategoryId(categoryId);
        setLanguageId(languageId);
    }

    public TranslationEntity() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getLanguageId() {
        return languageId;
    }

    public void setLanguageId(String languageId) {
        this.languageId = languageId;
    }
}
