package com.chat.chatroom.controller;

import java.util.HashMap;
import java.util.List;

public interface ChatService {
	public List<ChatDTO> getMonthChat(String chat_list_id);
	public int insertChat(ChatDTO dto);
	public int checkChatList(HashMap<String, String> map);
	public int insertChatDefault(HashMap<String, String> map);

}
