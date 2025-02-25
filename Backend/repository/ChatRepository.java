package com.socialMedia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.socialMedia.models.Chat;
import com.socialMedia.models.User;

public interface ChatRepository extends JpaRepository<Chat, Integer>{
	
	public List<Chat> findByUsersId(Integer userId);
	
	@Query("select c from Chat c where :user Member of c.users And :reqUser Member of c.users")
	public  Chat findChatByUserId(@Param("user") User user, @Param("reqUser") User reqUser );
	
	


}
