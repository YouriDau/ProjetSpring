package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.model.Category;
import com.spring.henallux.firstSpringProject.model.Language;
import com.spring.henallux.firstSpringProject.model.Translation;

import java.util.ArrayList;

public interface CategoryDataAccess {
    ArrayList<Category> findAllCategories();
    ArrayList<Language> findAllLanguages();
    ArrayList<Translation> findAllTranslations();
}
