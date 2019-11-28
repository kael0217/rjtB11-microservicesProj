package com.example.demo.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.InventoryRepository;
import com.example.demo.dto.Inventory;



@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired InventoryRepository irp;


	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int addShipping(Inventory inventory) {
		Inventory inv = irp.save(inventory);
		return inv.getId();
	}

	@Override
	public List<Inventory> getInventory() {
		return irp.findAll();
	}

	@Override
	public List<Inventory> getInventoryByAvailability(boolean availability) {
		return irp.getInventoryByAvailability(availability);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,isolation = Isolation.SERIALIZABLE)
	public boolean updateInventory(Inventory inventory) {
		try {
			irp.save(inventory);
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,isolation = Isolation.SERIALIZABLE)
	public boolean deleteInventory(int inventoryId) {
		try {
			irp.deleteById(inventoryId);
		}catch( Exception e ) {
			return false;
		}
		return true;
	}





}
