package com.example.demo.service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CategoryRepo;
import com.example.demo.dao.CommentRepo;
import com.example.demo.dao.ProductRepo;
import com.example.demo.dto.Cart;
import com.example.demo.dto.Category;
import com.example.demo.dto.Comment;
import com.example.demo.dto.Product;
import com.example.demo.dto.Reply;



@Service
public class DataPopulator implements CommandLineRunner {
	
	@Autowired CommentRepo rep;
	
	@Override
	public void run(String... args) throws Exception {
		
		Reply r1 = new Reply("kael", "useful");
		Reply r2 = new Reply("kaige", "very useful");
		Reply r3 = new Reply("cai", "impressive");
		
		List<Reply> ls1 = Arrays.asList(r1,r2);
		List<Reply> ls2 = Arrays.asList(r2,r3);
		
		Comment c1 = Comment.builder().id(1).pid(1).text("perfect good").username("kael").rating(4.9).replies(ls1).build();
		Comment c2 = Comment.builder().id(2).pid(1).text("best computer ever").username("kaige").rating(5.0).replies(ls2).build();
		
		rep.save(c1);
		rep.save(c2);

		
		
	}
	
}