package com.example.demo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.Category;

@Transactional
public interface CategoryRepo extends MongoRepository<Category, String>{

}
