package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.entity.OrderEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.OrderRepository;
import com.spring.henallux.firstSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.Cart;
import com.spring.henallux.firstSpringProject.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrderDAO implements OrderDataAccess {
    private OrderRepository orderRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public OrderDAO(OrderRepository orderRepository, ProviderConverter providerConverter) {
        this.orderRepository = orderRepository;
        this.providerConverter = providerConverter;
    }

    @Override
    public void saveOrder(Order order) {
        OrderEntity orderEntity = providerConverter.orderModelToOrderEntity(order);
        System.out.println(orderEntity.getUserPseudo());
        orderRepository.save(orderEntity);
    }

    @Transactional
    @Override
    public void updateOrderIsPaid(boolean isPaid, String username) {
        OrderEntity entity = orderRepository.findFirstByUserPseudoOrderByIdDesc(username);
        entity.setIsPaid(isPaid);
        orderRepository.save(entity);
    }
}
