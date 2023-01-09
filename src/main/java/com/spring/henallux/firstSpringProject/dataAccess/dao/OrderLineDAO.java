package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.entity.OrderEntity;
import com.spring.henallux.firstSpringProject.dataAccess.entity.OrderLineEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.OrderLineRepository;
import com.spring.henallux.firstSpringProject.dataAccess.repository.OrderRepository;
import com.spring.henallux.firstSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
public class OrderLineDAO implements OrderLineDataAccess {
    private ProviderConverter providerConverter;
    private OrderRepository orderRepository;

    private OrderLineRepository orderLineRepository;

    @Autowired
    public OrderLineDAO(ProviderConverter providerConverter, OrderRepository orderRepository, OrderLineRepository orderLineRepository) {
        this.providerConverter = providerConverter;
        this.orderRepository = orderRepository;
        this.orderLineRepository = orderLineRepository;
    }

    @Override
    public void saveCartItems(ArrayList<CartItem> items, String username) {
        OrderEntity orderEntity = orderRepository.findFirstByUserPseudoOrderByIdDesc(username);
        for (CartItem item : items) {
            orderLineRepository.save(providerConverter.cartItemToOrderLineEntity(item, orderEntity.getId()));
        }
    }
}
