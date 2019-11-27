package com.java.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.dto.Comment;
import com.java.dto.Reply;
import com.java.repository.CommentRepo;


public class CommentServiceImpl implements CommentService{

	@Autowired CommentRepo repo;
	
	@Override
	public Comment findCommentById(int id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public String addComment(Comment comment) {
		repo.insert(comment);
		return comment.getUsername();
	}

	@Override
	public void addReply(int cid, Reply reply) {
		Comment comment = repo.findById(cid).orElse(null);
		if(comment!=null) {
			if(comment.getReplies()==null) {
				List<Reply> replies = Arrays.asList(reply);
				comment.setReplies(replies);
				repo.save(comment);
			}else {
				List<Reply> replies = comment.getReplies();
				replies.add(reply);
				comment.setReplies(replies);
				repo.save(comment);
			}
		}
		
	}

}
