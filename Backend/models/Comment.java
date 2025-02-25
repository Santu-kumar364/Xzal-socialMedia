package com.socialMedia.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String comment;
	
    @ManyToOne
    private User user;
    
    @ManyToMany
    private List<User> liked = new ArrayList<>();
    
    private LocalDateTime createAt;
    
    
    
    public Comment() {
    	
    }
    
    
	public Comment(Integer id, String comment, User user, List<User> liked, LocalDateTime createAt) {
		super();
		this.id = id;
		this.comment = comment;
		this.user = user;
		this.liked = liked;
		this.createAt = createAt;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getLiked() {
		return liked;
	}

	public void setLiked(List<User> liked) {
		this.liked = liked;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}



}
