package com.chat.chatroom.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService {
	
	@Autowired
	ChatDAO dao;
	
	@Override
	public List<ChatDTO> getMonthChat(String chat_list_id) {
		return dao.getMonthChat(chat_list_id);
	}

	@Override
	public int insertChat(ChatDTO dto) {
		return dao.insertChat(dto);
	}

	@Override
	public int checkChatList(HashMap<String, String> map) {
		return dao.checkChatList(map);
	}

	@Override
	public int insertChatDefault(HashMap<String, String> map) {
		return dao.insertChatDefault(map);
	}

}
