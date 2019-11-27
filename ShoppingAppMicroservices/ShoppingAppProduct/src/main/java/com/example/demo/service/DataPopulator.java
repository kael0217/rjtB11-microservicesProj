package com.example.demo.service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CategoryRepo;
import com.example.demo.dao.ProductRepo;
import com.example.demo.dto.Cart;
import com.example.demo.dto.Category;
import com.example.demo.dto.Product;



@Service
public class DataPopulator implements CommandLineRunner {
	
	@Autowired CategoryRepo catRep;
	@Autowired ProductRepo rep;
	
	@Override
	public void run(String... args) throws Exception {
			
		
		Category c1= new Category("productive");
		Category c2= new Category("laptop");
		Category c3= new Category("electronic");
		
		catRep.save(c1);
		catRep.save(c2);
		catRep.save(c3);
		
		List<Category> ls1 = Arrays.asList(c1,c2);
		List<Category> ls2 = Arrays.asList(c2,c3);
		
		Product p1 = Product.builder().id(1).name("thinkpad").model("X1").brand("lenovo").categories(ls1).price(2210f).build();
		Product p2 = Product.builder().id(2).name("Macbook").model("16.3 inch").price(2400f).categories(ls2).build();
		
		rep.save(p1);
		rep.save(p2);
	}
	
}