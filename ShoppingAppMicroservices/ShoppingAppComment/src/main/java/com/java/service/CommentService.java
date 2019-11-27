package com.java.service;

import com.java.dto.Comment;
import com.java.dto.Reply;

public interface CommentService {
	public Comment findCommentById(int id);
	
	public String addComment(Comment comment);
	
	public void addReply(int cid, Reply reply);
	
}
