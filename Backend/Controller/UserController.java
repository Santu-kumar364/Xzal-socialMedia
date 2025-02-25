package com.socialMedia.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.socialMedia.config.JwtProvider;
import com.socialMedia.models.User;
import com.socialMedia.repository.UserRepository;
import com.socialMedia.service.UserService;

//import jakarta.servlet.http.HttpServletRequest;

@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/api/users")
	public List<User> getUsers() {
		List<User> users = userRepository.findAll();
 		
		return users;
	}
	
	
	@GetMapping("/api/users/{userId}")
	public User getUsersById(@PathVariable("userId") Integer id) throws Exception {
		
		User user = userService.findUserById(id);
		return user;
		
	} 
	
	@PutMapping("/api/users")
	public User updateUser(@RequestHeader("Authorization")String jwt, @RequestBody User user ) throws Exception {
		
		User reqUser = userService.findUserByJwt(jwt);
		User updatedUser = userService.updateUser(user,reqUser.getId());
		return updatedUser;
		
	}	
		 
	@PutMapping("/api/users/follow/{userId}")
	public User followingUserHandler(@RequestHeader("Authorization")String jwt, @PathVariable Integer userId) throws Exception {
		
		User reqUser = userService.findUserByJwt(jwt);
		User user = userService.followUser(reqUser.getId(), userId);
		return user;
	
	}
	
	@GetMapping("/api/users/search")
	public List<User> searchUser(@RequestParam("query") String query) {
		
		List<User> users = userService.searchUser(query);
		return users;
	}
	
	@GetMapping("/api/users/profile")
    public User getUserFromToken(@RequestHeader("Authorization")String jwt) {
		
		User user = userService.findUserByJwt(jwt);
		
		user.setPassword(null);
		
		return user;
	}

	
	
	
	
}














