package com.spring.henallux.firstSpringProject.dataAccess.util;


import com.spring.henallux.firstSpringProject.dataAccess.entity.ProductEntity;
import com.spring.henallux.firstSpringProject.dataAccess.entity.UserEntity;
import com.spring.henallux.firstSpringProject.model.Product;
import com.spring.henallux.firstSpringProject.model.User;
import org.springframework.stereotype.Component;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;


@Component
public class ProviderConverter {

    private Mapper mapper = new DozerBeanMapper();

    public User userEntityToUserModel(UserEntity userEntity) {
        User user = mapper.map(userEntity, User.class);
        user.setAccountNonExpired(userEntity.getAccountNonExpired());
        user.setAccountNonLocked(userEntity.getAccountNonLocked());
        user.setCredentialsNonExpired(userEntity.getCredentialsNonExpired());
        user.setEnabled((userEntity.getEnabled()));
        user.setAuthorities(userEntity.getAuthorities());
        return user;
    }


    public UserEntity userModelToUserEntity(User user) {
        return mapper.map(user, UserEntity.class);
    }

    public Product productEntityToProductModel(ProductEntity productEntity) {
        return mapper.map(productEntity, Product.class);
    }
}
