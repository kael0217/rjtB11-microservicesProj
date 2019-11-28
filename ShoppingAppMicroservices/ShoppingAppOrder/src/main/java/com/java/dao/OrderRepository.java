package com.java.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.java.dto.Order;

@Transactional
public interface OrderRepository extends JpaRepository<Order, Integer>, OrderCustRepository{

}
