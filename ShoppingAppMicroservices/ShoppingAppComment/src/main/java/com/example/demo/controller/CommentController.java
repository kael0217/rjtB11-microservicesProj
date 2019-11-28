package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.CommentService;

@Controller
public class CommentController {
	@Autowired CommentService service;
	
	@PostMapping("/comment")
	public void Comment(int pid, String username, String text,double rating) {
		service.Comment(pid, username, text, rating);
	}
	
	@PostMapping("/reply")
	public void Reply(int id, String username, String text) {
		service.Reply(id, username, text);
	}
	
	@DeleteMapping("/delete")
	public void Delete(int id) {
		service.DeleteComment(id);
	}
	
	

}
