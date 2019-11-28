package com.example.demo.service;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CommentRepo;
import com.example.demo.dto.Comment;
import com.example.demo.dto.Reply;

@Service
public class CommentServiceImpl implements CommentService{
	@Autowired CommentRepo rep;
	
	@Override
	@Transactional
	public void Comment(int pid, String username, String text, double rating) {
		Comment comment = Comment.builder().pid(pid).username(username).text(text).rating(rating).build();
		rep.save(comment);
		
	}

	@Override
	@Transactional
	public void Reply(int id, String username, String text) {
		Reply reply = new Reply(username, text);
		Comment comment = rep.findById(id).orElse(new Comment());
		if (comment.getReplies()==null) {
			List<Reply> replies = Arrays.asList(reply);
			comment.setReplies(replies);
		}else {
			List<Reply> replies = comment.getReplies();
			replies.add(reply);
			comment.setReplies(replies);
		}
		rep.save(comment);
		
	}

	@Override
	@Transactional
	public void DeleteComment(int id) {
		rep.deleteById(id);
		
	}
	
//	@Override
//	public void DeleteCommentByPid(int pid) {
//		rep.DeleteCommentsByPid(pid);
//		
//	}
	

//	@Override
//	public void DeleteCommentByUserAndProductId(int pid, String username) {
//		rep.DeleteCommentsByUsernameAndPid(username, pid);
//		
//	}
	
}
