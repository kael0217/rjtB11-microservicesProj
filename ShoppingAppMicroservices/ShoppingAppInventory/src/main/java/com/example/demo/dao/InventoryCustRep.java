package com.example.demo.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.demo.dto.Inventory;



public interface InventoryCustRep {
	//http://localhost:8080/carts/search/getCartByCustomerId?customerId=admin
	@RestResource
	@Query(nativeQuery=true, value="select * from Inventory where availability =?1")
	List<Inventory> getInventoryByAvailability( boolean availability );

	
	
	
}
