package com.java.service;

import java.time.LocalDateTime;
import java.util.List;

import com.java.dto.Order;

public interface OrderService {
	
	public Order retrieveAccountById( String orderId );
	
	public List<Order> orderListAfterDate( LocalDateTime date );
	
	public boolean cancelAnOrder( String orderId );
	
}
