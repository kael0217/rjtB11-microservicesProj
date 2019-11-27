package com.java.service;

import java.util.List;

import com.java.dto.Product;

public interface ProductService {
	public List<Product> findAll();
	
	public List<Product> findProductsByCategory(String categoryName);
	
	public List<Product> findProductsByName(String searchString);
	
	public List<Product> searchProductsByRegex(String searchString);
	
	void updateProductsRemained(Product product, int inStore);

	public Product findById(int id);
	
	void addProduct(Product product);
	
	public void deleteProduct(int id);
	
	//public void updateProduct(Product product);
	//public List<Product> findHisProducts(String username, int page, int limit);
}
