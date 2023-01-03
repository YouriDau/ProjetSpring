package com.spring.henallux.firstSpringProject.dataAccess.repository;

import com.spring.henallux.firstSpringProject.dataAccess.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Transactional
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,String> {
    ArrayList<ProductEntity> findAll();
    ProductEntity findByName(String name);
    ArrayList<ProductEntity> findByCategoryId(Integer id);
}
