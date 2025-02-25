package com.socialMedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialMedia.models.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
	

}