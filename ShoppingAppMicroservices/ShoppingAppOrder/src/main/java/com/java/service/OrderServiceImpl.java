package com.java.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.OrderRepository;
import com.java.dto.Order;
import com.java.dto.Order.OrderStatus;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired OrderRepository or;
	
	@Override
	public Order retrieveAccountById(Integer orderId) {
		Optional<Order> ord = or.findById(orderId);
		if( ord.isPresent() ) {
			return ord.get();
		}
		return null;
	}

	@Override
	public boolean cancelAnOrder(Integer orderId) {
		Optional<Order> ord = or.findById(orderId);
		if( ord.isPresent() ) {
			Order o = ord.get();
			if( o.getStatus() != OrderStatus.Canceled && o.getStatus() != OrderStatus.Paid ){
				o.setStatus(OrderStatus.Canceled);
				or.save(o);
				return true;
			}
			else
				return false;
			
		}
		return false;
	}

}
