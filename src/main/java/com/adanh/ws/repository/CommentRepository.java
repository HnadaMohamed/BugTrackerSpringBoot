package com.adanh.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adanh.ws.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
	

}
