package com.socialMedia.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialMedia.request.LoginRequest;
import com.socialMedia.config.JwtProvider;
import com.socialMedia.models.User;
import com.socialMedia.repository.UserRepository;
import com.socialMedia.response.AuthResponse;
import com.socialMedia.service.CustomerUserDetailsService;
 

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
 	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private CustomerUserDetailsService customerUserDetails;
	
//     /auth/signup	
	@PostMapping("/signup")
	public AuthResponse signup(@RequestBody User user ) throws Exception {
		
		User isExist = userRepository.findByEmail(user.getEmail());
		
		if(isExist != null) {
			throw new Exception("this email already used with another account");
		}
		
		User newUser = new User();
		newUser.setEmail(user.getEmail());
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setPassword(passwordEncoder.encode(user.getPassword()));
		 
		
		User savedUser = userRepository.save(newUser);
		
		Authentication authentication = new UsernamePasswordAuthenticationToken(savedUser.getEmail(), savedUser.getPassword());
		
		String token = JwtProvider.generatedToken(authentication);
		
		AuthResponse res = new AuthResponse(token, "Register Success");
		
		return res;
				
	}

	
//  auth/signin	
	@PostMapping("/signin")
	public AuthResponse signin(@RequestBody LoginRequest loginRequest ) {
		
		Authentication authentication = 
				authentication(loginRequest.getEmail(), loginRequest.getPassword());
				
        String token = JwtProvider.generatedToken(authentication);
		
		AuthResponse res = new AuthResponse(token, "Login Success");
		
		return res;
	}

	private Authentication authentication(String email, String password) {
		UserDetails userDetails = customerUserDetails.loadUserByUsername(email);
		
		if(userDetails == null) {
			throw new BadCredentialsException("invalid username");
		}
		if(!passwordEncoder.matches(password, userDetails.getPassword())) {
			throw new BadCredentialsException("password not matched");
		}
		return new UsernamePasswordAuthenticationToken(userDetails,
				null,
				userDetails.getAuthorities());
	}

}


