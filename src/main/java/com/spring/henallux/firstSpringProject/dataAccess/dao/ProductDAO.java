package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.entity.ProductEntity;
import com.spring.henallux.firstSpringProject.dataAccess.entity.TranslationEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.ProductRepository;
import com.spring.henallux.firstSpringProject.dataAccess.repository.TranslationRepository;
import com.spring.henallux.firstSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Array;
import java.util.ArrayList;

@Service
@Transactional
public class ProductDAO implements ProductDataAccess {
    private ProductRepository productRepository;
    private TranslationRepository translationRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public ProductDAO(ProductRepository productRepository, TranslationRepository translationRepository, ProviderConverter providerConverter) {
        this.productRepository = productRepository;
        this.translationRepository = translationRepository;
        this.providerConverter = providerConverter;
    }

    public ArrayList<Product> findAll() {
        ArrayList<ProductEntity> productEntities = productRepository.findAll();
        ArrayList<Product> products = new ArrayList<>();
        for(ProductEntity entity : productEntities) {
            Product product = providerConverter.productEntityToProductModel(entity);
            products.add(product);
        }
        return products;
    }

    public Product findByName(String name) {
        ProductEntity productEntity = productRepository.findByName(name);
        return providerConverter.productEntityToProductModel(productEntity);
    }

    public ArrayList<Product> findByTranslationLabel(String label) {
        TranslationEntity translationEntity = translationRepository.findByLabel(label);
        ArrayList<ProductEntity> productEntities = productRepository.findByCategoryId(translationEntity.getCategoryId());

        ArrayList<Product> products = new ArrayList<>();
        for(ProductEntity entity : productEntities) {
            products.add(providerConverter.productEntityToProductModel(entity));
        }
        return products;
    }
}
