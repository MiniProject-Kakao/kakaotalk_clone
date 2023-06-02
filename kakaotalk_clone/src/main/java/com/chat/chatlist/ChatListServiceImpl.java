package com.chat.chatlist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatListServiceImpl implements ChatListService {
	
	@Autowired
	ChatListDAO dao;
	
	@Override
	public List<ChatListDTO> getAllChatList(String user_id) {
		return dao.getAllChatList(user_id);
	}

}
