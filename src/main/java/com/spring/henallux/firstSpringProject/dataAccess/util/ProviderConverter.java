package com.spring.henallux.firstSpringProject.dataAccess.util;


import com.spring.henallux.firstSpringProject.dataAccess.entity.*;
import com.spring.henallux.firstSpringProject.model.*;
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

    public Category translationEntityToCategoryModel(TranslationEntity translationEntity) {
        Category category = new Category();

        category.setId(translationEntity.getCategoryId());
        category.setLabel(translationEntity.getLabel());
        category.setLanguage(translationEntity.getLanguageId());

        return category;
    }

    public Promotion promotionEntityToPromotionModel(PromotionEntity promotionEntity) {
        return mapper.map(promotionEntity, Promotion.class);
    }

    public Order orderEntityToOrderModel(OrderEntity orderEntity) {
        return mapper.map(orderEntity, Order.class);
    }
    public OrderEntity orderModelToOrderEntity(Order order) {
        return mapper.map(order, OrderEntity.class);
    }

    public OrderLineEntity cartItemToOrderLineEntity(CartItem item, Integer orderId) {
        int quantity = item.getQuantity();
        double unitPrice = item.getProduct().getUnitPrice();
        int productId = item.getProduct().getId();
        OrderLineEntity orderLineEntity = new OrderLineEntity();

        orderLineEntity.setQuantity(quantity);
        orderLineEntity.setUnitPrice(unitPrice);
        orderLineEntity.setProductId(productId);
        orderLineEntity.setOrderId(orderId);

        return orderLineEntity;
    }

}
