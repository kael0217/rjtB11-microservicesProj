package com.example.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.dto.Inventory;

@Transactional

@RepositoryRestResource(path="inventory")
public interface InventoryRepository extends JpaRepository<Inventory, Integer>, InventoryCustRep{


	
}