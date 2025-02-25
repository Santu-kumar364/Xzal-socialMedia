package com.socialMedia.service;

import java.util.List;

import com.socialMedia.exceptions.UserException;
import com.socialMedia.models.User;

public interface UserService {
	
	public User registerUser(User user);
	
	public User findUserById(Integer userId) throws UserException;
	
	public User findUserByEmail(String Email);
	
	public User followUser(Integer userId1, Integer userId2) throws UserException;
	
	public User updateUser(User user, Integer userId) throws UserException;
		
	public List<User> searchUser(String query);
	
	public User findUserByJwt(String jwt);
	

}