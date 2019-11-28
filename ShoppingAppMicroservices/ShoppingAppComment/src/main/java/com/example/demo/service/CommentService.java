package com.example.demo.service;

import org.springframework.stereotype.Service;


public interface CommentService {
	public void Comment(int pid, String username, String text, double rating);
	
	public void Reply(int id, String username, String text);
	
	public void DeleteComment(int id);
	
	//public void DeleteCommentByPid(int pid);
	
	//public void DeleteCommentByUserAndProductId(int pid, String username);
}
