package com.socialMedia.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialMedia.models.Comment;
import com.socialMedia.models.Post;
import com.socialMedia.models.User;
import com.socialMedia.repository.CommentRepository;
import com.socialMedia.repository.PostRepository;

@Service
public class CommentServiceImpIemention implements CommentService {
    
	@Autowired
	private PostService postService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public Comment createComment(Comment comment,
			Integer postId,
			Integer UserId) throws Exception {
		
		User user = userService.findUserById(UserId);
		
		Post post = postService.findPostById(postId);
		
		comment.setUser(user);
		comment.setComment(comment.getComment());
		comment.setCreateAt(LocalDateTime.now());
		
		Comment savedComment = commentRepository.save(comment);
		post.getComments().add(savedComment);
		
		postRepository.save(post);
				 
		return savedComment;
	}
	

	@Override
	public Comment findCommentById(Integer commentId) throws Exception {
		Optional<Comment> opt = commentRepository.findById(commentId);
		
		if(opt.isEmpty()) {
			throw new Exception("comment not exist");
		}
		return opt.get();
	}

	
	@Override
	public Comment likeComment(Integer CommentId, Integer userId) throws Exception {
		Comment comment = findCommentById(CommentId);
		User user = userService.findUserById(CommentId);
		
		if(!comment.getLiked().contains(user)) {
			comment.getLiked().add(user);
		}
		else comment.getLiked().remove(user);
		
		return commentRepository.save(comment);
	}

}

















