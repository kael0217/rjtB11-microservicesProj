package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Shipping;


public interface ShippingService {
	
	int addShipping(Shipping shipping );
	
	List<Shipping> getShipping();
	
	List<Shipping> getShippingBySenderId(String senderId);
	
	Shipping getShippingByOrderId(String orderId);
		
	boolean updateShipping(Shipping shipping);
	
	boolean deleteShipping(int shippingId);
	
}
