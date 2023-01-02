package com.spring.henallux.firstSpringProject.model;

public class Category {
    private Integer id;
    private String label;
    private String language;

    public Category(Integer id, String label, String language) {
        setId(id);
        setLabel(label);
        setLanguage(language);
    }

    public Category() {}

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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
