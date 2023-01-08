package com.spring.henallux.firstSpringProject.dataAccess.repository;

import com.spring.henallux.firstSpringProject.dataAccess.entity.TranslationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Transactional
@Repository
public interface TranslationRepository extends JpaRepository<TranslationEntity, Integer> {
    ArrayList<TranslationEntity> findByLanguageIdLike(String locale);

    TranslationEntity findByLabelAndLanguageId(String label, String language);
}
