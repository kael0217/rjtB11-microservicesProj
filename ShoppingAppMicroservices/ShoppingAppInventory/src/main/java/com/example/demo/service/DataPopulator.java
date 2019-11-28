package com.example.demo.service;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.example.demo.dao.InventoryRepository;
import com.example.demo.dto.Address;
import com.example.demo.dto.Inventory;




@Service
public class DataPopulator implements CommandLineRunner {
	
	@Autowired InventoryRepository inv;
	
	@Override
	public void run(String... args) throws Exception {
		
		Address a1=Address.builder().hno(1).street("main street").city("Chicago").state("IL").pincode(60174).build();
		Address a2=Address.builder().hno(2).street("south street").city("New York City").state("NY").pincode(60111).build();
		Map<String, Integer> items = new HashMap<>();
		items.put("Duracell AAA batteries 4 ct", 2);
		Inventory i1 = Inventory.builder().id(1).address(a2).itemsMap(items).availability(true).build();
		Inventory i2 = Inventory.builder().id(2).address(a1).itemsMap(items).availability(true).build();
		inv.save(i1);
		inv.save(i2);

	}
	
}