package com.example.demo.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CartRepository;
import com.example.demo.dto.Cart;


@Service
public class CartServiceImpl implements CartService {

	@Autowired CartRepository crp;



	@Override
	public int addHotel(Cart cart) {
		Cart ct = crp.save(cart);
		return ct.getId();
	}

	@Override
	public Cart getCartById(String cartId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cart> getCartByCustomerId(String customerId) {
		return crp.getCartByCustomerId(customerId);
	}

	@Override
	public boolean updateCart(Cart cart) {
		try {
			crp.save(cart);
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteCart(int cartId) {
		try {
			crp.deleteById(cartId);
		}catch( Exception e ) {
			return false;
		}
		return true;
	}

	@Override
	public List<Cart> getCart() {
		return crp.findAll();
	}

}
