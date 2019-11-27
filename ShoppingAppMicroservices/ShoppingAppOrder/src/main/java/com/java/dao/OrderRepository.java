package com.java.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.dto.Order;

public interface OrderRepository extends JpaRepository<Order, String>, OrderCustRepository{

}
