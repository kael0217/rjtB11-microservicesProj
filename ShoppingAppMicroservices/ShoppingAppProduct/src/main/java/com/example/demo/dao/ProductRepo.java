package com.example.demo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.Product;

@Transactional
public interface ProductRepo extends MongoRepository<Product, Integer>{
	
}
