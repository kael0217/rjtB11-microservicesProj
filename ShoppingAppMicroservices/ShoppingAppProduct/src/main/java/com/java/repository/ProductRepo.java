package com.java.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.java.dto.Product;

@Repository("productRepo")
public interface ProductRepo extends MongoRepository<Product, Integer> {
	
	List<Product> findProductsByCategory(String categoryName);
	
	List<Product> findByInStoreGreaterThan(int inStore, Pageable page);
	
	@Query("{inStore:{$gt:0}, $text:{$search: ?0}}")
	List<Product> searchProduct(String keyword);
	

	/*@Query("{ inStore:{$gt:0},'category.productName':   ?0 }")*/
	List<Product> findProductsByCategoryProductNameAndInStoreGreaterThan(String productName,int inStore, Pageable page);
	/*
	 * db.products.find( { 'productName': /mens/i } );
	 * 
	 * @Query("{ 'productName': /?0/i }")
	 * 
	 */
	@Query("{inStore:{$gt:0}, 'productName':{$regex:?0,$options:'i'} }")
	List<Product> findProductsByProductNameRegex(String searchString);
	
	List<Product> findProductsByProductNameAndInStoreGreaterThan(String searchString, int inStore);

	@Query("{inStore:{$gt:0}, 'sku' : ?0 }")
	Product findBySku(String sku);
}
