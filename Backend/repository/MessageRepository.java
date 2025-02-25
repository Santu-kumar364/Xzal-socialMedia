package com.socialMedia.repository;

import java.util.List;

import com.socialMedia.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {
	
	public List<Message> findByChatId(Integer chatId);
 
}

