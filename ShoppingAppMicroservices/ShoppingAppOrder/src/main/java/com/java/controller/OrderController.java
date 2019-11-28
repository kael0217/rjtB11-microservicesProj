package com.java.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.dao.OrderRepository;
import com.java.dto.Order;
import com.java.dto.Order.OrderStatus;

@RequestMapping("/orders")
@RestController
public class OrderController {
	
	@Autowired OrderRepository or;
	
	@PostMapping
	public boolean generateOrder( Order order ) {
		or.save(order);
		return true;
	}
	
	@GetMapping("/{orderId}")
	public Order getOrderById( @PathVariable Integer orderId ) {
		Optional<Order> acc = or.findById(orderId);
		if( acc.isPresent() ) {
			return acc.get();
		}
		return null;
	}
	
	@GetMapping("/list/{username}")
	public List<Order> getOrderListByUsername( @PathVariable String username ){
		return or.findByUsername(username);
	}
	
	@GetMapping("/list/{username}/{date}")
	public List<Order> getOrderListByUsernameAndDate( @PathVariable String username, @PathVariable LocalDate date){
		return or.findOrderByUsernameAndAfterDate(username, date);
	}
	
	@PatchMapping("/cancel/{orderId}")
	public boolean cancelOrder( @PathVariable Integer orderId ) {
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
	
	
	@PatchMapping("/confirm/{orderId}")
	public boolean confirmOrder( @PathVariable Integer orderId ) {
		Optional<Order> ord = or.findById(orderId);
		if( ord.isPresent() ) {
			Order o = ord.get();
			if( o.getStatus() == OrderStatus.Initiated ){
				o.setStatus(OrderStatus.Confirmed);
				or.save(o);
				return true;
			}
			else
				return false;
			
		}
		return false;
	}
	
	@PatchMapping
	public boolean updateOrder( Order order ) {
		Optional<Order> ord = or.findById(order.getOrderId());
		if( ord.isPresent() ) {
			or.save(order);
			return true;
		}
		else
			return false;
	}
	
	@PatchMapping(path="/insert")
	public boolean updateOrder( @RequestParam Integer orderId, @RequestParam String productId, @RequestParam Integer quantity ) {
		Optional<Order> ord = or.findById(orderId);
		if( ord.isPresent() ) {
			Order o = ord.get();
			o.getProductList().put(productId, quantity);
			or.save(o);
			return true;
		}
		else
			return false;
	}
	
	@DeleteMapping("/{orderId}")
	public boolean deleteOrder( @PathVariable Integer orderId ) {
		if( or.findById(orderId).isPresent() ) {
			or.deleteById(orderId);
			return true;
		}
		return false;
	}
	
}
