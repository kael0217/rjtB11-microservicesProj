package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.dto.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>, CartCustRep  {
	
}