package com.socialMedia.service;

import com.socialMedia.models.Comment;

public interface CommentService {
	
	public Comment createComment(
			Comment comment,
			Integer postId,
			Integer UserId
			) throws Exception;
	
	public Comment findCommentById(Integer commentId) throws Exception;
	
	public Comment likeComment(Integer CommentId, Integer userId) throws Exception;
	
	

}
