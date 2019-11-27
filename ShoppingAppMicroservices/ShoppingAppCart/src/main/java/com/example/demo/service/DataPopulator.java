package com.example.demo.service;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CartRepository;
import com.example.demo.dto.Cart;



@Service
public class DataPopulator implements CommandLineRunner {
	
	@Autowired CartRepository cart;
	
	@Override
	public void run(String... args) throws Exception {
			
		Map<String, Integer> items = new HashMap<>();
		items.put("Duracell AAA batteries 4 ct", 2);
		Cart c1 = Cart.builder().id(1).customerId("admin").itemsMap(items).build();
		Cart c2 = Cart.builder().id(2).customerId("admin").itemsMap(items).build();
		cart.save(c1);
		cart.save(c2);

	}
	
}