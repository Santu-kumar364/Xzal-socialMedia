package com.socialMedia.service;


import java.util.List;

import com.socialMedia.models.Chat;
import com.socialMedia.models.User;

public interface ChatService {
	
	public Chat createChat(User reqUser, User user2);
	
	public Chat findChatById(Integer chatId) throws Exception;
	 
	
	public List<Chat> findUsersChat(Integer userId);
	 

}
