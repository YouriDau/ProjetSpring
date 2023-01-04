package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.entity.PromotionEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.PromotionRepository;
import com.spring.henallux.firstSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class PromotionDAO implements PromotionDataAccess {
    private PromotionRepository promotionRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public PromotionDAO(PromotionRepository promotionRepository, ProviderConverter providerConverter) {
        this.promotionRepository = promotionRepository;
        this.providerConverter = providerConverter;
    }

    @Override
    public Promotion findByProductId(Integer productId) {
        Date today = new Date();

        PromotionEntity promotionEntity = promotionRepository.findOneByProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(productId, today, today);
        if (promotionEntity != null) {
           return providerConverter.promotionEntityToPromotionModel(promotionEntity);
        } else {
            return null;
        }
    }
}
