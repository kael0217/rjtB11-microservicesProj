package com.example.demo.dao;

import javax.transaction.Transactional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.Comment;

@Repository("CommentRepo")
@Transactional
public interface CommentRepo extends MongoRepository<Comment, Integer>{
	//public void DeleteCommentsByPid(int pid);
	
	//public void DeleteCommentsByUsernameAndPid(String username, int pid);
}
