package com.java.service;


import com.java.dto.Order;

public interface OrderService {
	
	public Order retrieveAccountById( Integer orderId );
	
	public boolean cancelAnOrder( Integer orderId );
	
}
