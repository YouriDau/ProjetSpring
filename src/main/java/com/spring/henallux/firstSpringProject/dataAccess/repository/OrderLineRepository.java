package com.spring.henallux.firstSpringProject.dataAccess.repository;

import com.spring.henallux.firstSpringProject.dataAccess.entity.OrderLineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface OrderLineRepository extends JpaRepository<OrderLineEntity,String> {

}
