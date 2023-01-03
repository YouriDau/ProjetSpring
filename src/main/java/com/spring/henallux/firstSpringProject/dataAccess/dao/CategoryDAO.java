package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.entity.CategoryEntity;
import com.spring.henallux.firstSpringProject.dataAccess.entity.TranslationEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.TranslationRepository;
import com.spring.henallux.firstSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.Category;
import com.spring.henallux.firstSpringProject.model.Translation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class CategoryDAO implements CategoryDataAccess {
    private TranslationRepository translationRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public CategoryDAO(TranslationRepository translationRepository, ProviderConverter providerConverter) {
        this.translationRepository = translationRepository;
        this.providerConverter = providerConverter;
    }


    @Override
    public ArrayList<Category> findAllByLocale(String locale) {
        ArrayList<TranslationEntity> translations = translationRepository.findByLanguageIdLike(locale);
        ArrayList<Category> categories = new ArrayList<>();
        for (TranslationEntity entity : translations) {
            categories.add(providerConverter.translationEntityToCategoryModel(entity));
        }
        return categories;
    }
}
