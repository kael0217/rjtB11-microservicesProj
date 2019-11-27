package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Cart;


public interface CartService {
	
	int addHotel(Cart cart );
	
	List<Cart> getCart();
	
	Cart getCartById(String cartId);
	
	List<Cart> getCartByCustomerId(String customerId);
	
	boolean updateCart(Cart cart);
	
	boolean deleteCart(int cartId);
	
}
