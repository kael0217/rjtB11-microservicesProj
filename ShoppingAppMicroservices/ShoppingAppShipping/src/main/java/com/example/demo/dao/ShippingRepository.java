package com.example.demo.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.Shipping;

@Transactional
public interface ShippingRepository extends JpaRepository<Shipping, Integer>, ShippingCustRep  {


	
}