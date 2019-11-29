package com.example.demo.service;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ShippingRepository;
import com.example.demo.dto.Address;
import com.example.demo.dto.Shipping;



@Service
public class DataPopulator implements CommandLineRunner {
	
	@Autowired ShippingRepository shipping;
	
	@Override
	public void run(String... args) throws Exception {
		
		Address a1=Address.builder().hno(1).street("main street").city("Chicago").state("IL").pincode(60174).build();
		Address a2=Address.builder().hno(2).street("south street").city("New York City").state("NY").pincode(60111).build();
		
		Shipping s1 = Shipping.builder().id(1).address(a2).storeId(1).orderId("o1").customerName("Harry").weight(1.1f).price(5f).build();
		Shipping s2 = Shipping.builder().id(2).address(a1).storeId(2).orderId("o2").customerName("James").weight(1.1f).price(5f).build();
		shipping.save(s1);
		shipping.save(s2);

	}
	
}