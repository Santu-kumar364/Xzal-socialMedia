package com.socialMedia.service;

import java.util.List;

//import com.socialMedia.models.Chat;
import com.socialMedia.models.Message;
import com.socialMedia.models.User;

public interface MessageService {
	
	public Message createMessage(User user, Integer chatId, Message req) throws Exception;
	public List<Message> findChatsMessages(Integer chatId) throws Exception;

}
