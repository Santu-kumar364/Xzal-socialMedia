/*package com.socialMedia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialMedia.models.Reels;
import com.socialMedia.models.User;
import com.socialMedia.repository.ReelsRepository;


@Service
public class ReelsServiceImplemention implements ReelsService {
    
	@Autowired
	private ReelsRepository reelsRepository;
	
	@Autowired
	private UserService userService;
	
	@Override
	public Reels createReels(Reels reel, User user) {
		
		Reels createReel = new Reels();
		
		createReel.setTitle(reel.getTitle());
		createReel.setUser(user);
		createReel.setVideo(reel.getVideo());
		
		return reelsRepository.save(createReel);
		
	}

	@Override
	public List<Reels> findAllReels() {
		
		return reelsRepository.findAll();
	}

	
	@Override
	public List<Reels> findUsersReel(Integer userId) throws Exception {
		userService.findUserById(userId);
		 
		return reelsRepository.findByUserId(userId);
	}

}
*/












