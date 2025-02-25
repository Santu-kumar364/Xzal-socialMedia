package com.socialMedia.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	private String captions;
	private String image;
	private String video;
	
	
	@ManyToOne
	private User user;
	private LocalDateTime createAt;
	
	@OneToMany
	private List<User> liked = new ArrayList<>();
	
	@OneToMany
	private List<Comment> comments = new ArrayList<>();
	
	public Post() {
		
	}

	public Post(Integer id, String captions, String image, String video, User user, LocalDateTime createAt,
			List<User> liked, List<Comment> comments) {
		super();
		Id = id;
		this.captions = captions;
		this.image = image;
		this.video = video;
		this.user = user;
		this.createAt = createAt;
		this.liked = liked;
		this.comments = comments;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getCaptions() {
		return captions;
	}

	public void setCaptions(String captions) {
		this.captions = captions;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	public List<User> getLiked() {
		return liked;
	}

	public void setLiked(List<User> liked) {
		this.liked = liked;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	
	
	
}	 
