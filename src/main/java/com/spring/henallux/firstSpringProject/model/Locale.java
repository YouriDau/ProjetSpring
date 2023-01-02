package com.spring.henallux.firstSpringProject.model;

public class Locale {
    private String locale;

    public Locale(String locale) {
        setLocale(locale);
    }

    public Locale(){}

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }
}
