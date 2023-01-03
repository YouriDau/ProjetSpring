package com.spring.henallux.firstSpringProject.dataAccess.repository;

import com.spring.henallux.firstSpringProject.dataAccess.entity.PromotionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;

@Transactional
@Repository
public interface PromotionRepository extends JpaRepository<PromotionEntity,String> {
    PromotionEntity findOneByProductIdAndStartDateGreaterThanEqualAndEndDateGreaterThanEqual(Integer productId, Date startDate, Date endDate);
}
