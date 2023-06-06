package com.chat.chatlist;

import java.util.HashMap;
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

	@Override
	public int updateLastChat(ChatListDTO dto) {
		return dao.updateLastChat(dto);
	}

	@Override
	public String getSpecificChatRoom(HashMap<String, String> map) {
		return dao.getSpecificChatRoom(map);
	}

	@Override
	public int setChatList(HashMap<String, String> map) {
		return dao.setChatList(map);
	}

	@Override
	public String getSpecificChatRoom2(HashMap<String, String> map) {
		return dao.getSpecificChatRoom2(map);
	}

	@Override
	public int firstinsertuserjoin(HashMap<String, String> map) {
		return dao.firstinsertuserjoin(map);
	}

	@Override
	public int secondinsertuserjoin(HashMap<String, String> map) {
		return dao.secondinsertuserjoin(map);
	}

	@Override
	public int updateLastChatDefault(String chat_list_id) {
		return dao.updateLastChatDefault(chat_list_id);
	}

}
