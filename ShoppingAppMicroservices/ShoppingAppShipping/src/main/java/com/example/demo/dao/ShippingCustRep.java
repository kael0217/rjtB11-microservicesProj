package com.example.demo.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.demo.dto.Shipping;


public interface ShippingCustRep {
	//http://localhost:8080/carts/search/getCartByCustomerId?customerId=admin
	@RestResource
	@Query(nativeQuery=true, value="select * from Shipping where senderId =?1")
	List<Shipping> getShippingBySenderId( String senderId );

	@RestResource
	@Query(nativeQuery=true, value="select * from Shipping where orderId =?1")
	Shipping getShippingByOrderId(String orderId);
	
	
}
