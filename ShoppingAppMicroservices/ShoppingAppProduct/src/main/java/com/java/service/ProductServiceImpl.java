package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.dto.Product;
import com.java.repository.ProductRepo;

public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepo rep;
	
	@Override
	public List<Product> findAll() {
		
		return rep.findAll();
	}

	
	@Override
	public List<Product> findProductsByCategory(String categoryName) {
		return rep.findProductsByCategory(categoryName);
	}

	@Override
	public List<Product> findProductsByName(String searchString) {
		return rep.findProductsByProductNameRegex(searchString);
	}
	
	@Override
	public List<Product> searchProductsByRegex(String searchString){
		return rep.searchProduct(searchString);
	}
	
	@Override
	public void updateProductsRemained(Product product, int inStore) {
		product.setInStore(inStore);
		rep.save(product);
	}
	

	@Override
	public void addProduct(Product product) {
		rep.save(product);
		
	}
	

	@Override
	public Product findById(int id) {
		return rep.findById(id).orElse(new Product());
	}
//	@Override
//	public void updateProduct(Product product) {
//		rep.updateProduct(product);
//		
//	}
	@Override
	public void deleteProduct(int id) {
		rep.deleteById(id);
	}



}
