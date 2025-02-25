package com.socialMedia.service;
 
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialMedia.models.Chat;
import com.socialMedia.models.Message;
import com.socialMedia.models.User;
import com.socialMedia.repository.ChatRepository;
import com.socialMedia.repository.MessageRepository;

@Service
public class MessageServiceImplemention implements MessageService {
	
	@Autowired 
	private MessageRepository messageRepository;
	
	@Autowired
	private ChatService chatService;
	
	@Autowired
	private ChatRepository chatRepository;
	
	

	@Override
	public Message createMessage(User user, Integer chatId, Message req) throws Exception {
		
		Chat chat = chatService.findChatById(chatId);
		Message message = new Message();
		
		
		message.setChat(chat);
		message.setContent(req.getContent());
		message.setUser(user);
		message.setImage(req.getImage());
		message.setTimestamps(LocalDateTime.now());
		
		Message savedMessage = messageRepository.save(message); 
		
		chat.getMessage().add(savedMessage);
		chatRepository.save(chat);
		
		return savedMessage;
		
		 
	}

	@Override
	public List<Message> findChatsMessages(Integer chatId) throws Exception {
		//Chat chat = chatService.findChatById(chatId);
		return messageRepository.findByChatId(chatId);
	}

}






