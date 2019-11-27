package com.java.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.java.dto.Comment;

@Repository("CommentRepo")
public interface CommentRepo extends MongoRepository<Comment, Integer>{

}
