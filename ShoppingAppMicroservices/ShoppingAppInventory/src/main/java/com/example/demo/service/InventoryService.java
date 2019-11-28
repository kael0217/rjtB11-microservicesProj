package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Inventory;



public interface InventoryService {
	
	int addShipping(Inventory inventory );
	
	List<Inventory> getInventory();
	
	List<Inventory> getInventoryByAvailability(boolean availability);
	
		
	boolean updateInventory(Inventory inventory);
	
	boolean deleteInventory(int inventoryId);
	
}
