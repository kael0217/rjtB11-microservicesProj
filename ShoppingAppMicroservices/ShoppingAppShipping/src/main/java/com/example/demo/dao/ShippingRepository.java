package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.Shipping;
@Transactional
//public interface ShippingRepository extends JpaRepository<Shipping, Integer>, ShippingCustRep  {
public interface ShippingRepository extends JpaRepository<Shipping, Integer> {
	//http://localhost:8080/carts/search/getCartByCustomerId?customerId=admin
		
		//@Query(nativeQuery=true, value="select * from Shipping where storeId =?1")
		List<Shipping> getShippingByStoreId( int storeId );

	
		//@Query(nativeQuery=true, value="select * from Shipping where orderId =?1")
		Shipping getShippingByOrderId(String orderId);
	
}