package com.chat.chatlist;

import java.util.List;

public interface ChatListService {
	public List<ChatListDTO> getAllChatList(String user_id);
	public int updateLastChat(ChatListDTO dto);

}
