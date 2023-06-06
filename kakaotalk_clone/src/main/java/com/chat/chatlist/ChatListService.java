package com.chat.chatlist;

import java.util.HashMap;
import java.util.List;

public interface ChatListService {
	public List<ChatListDTO> getAllChatList(String user_id);
	public int updateLastChat(ChatListDTO dto);
	public String getSpecificChatRoom(HashMap<String, String> map);
	public int setChatList(HashMap<String, String> map);
	public String getSpecificChatRoom2(HashMap<String, String> map);
	public int firstinsertuserjoin(HashMap<String, String> map);
	public int secondinsertuserjoin(HashMap<String, String> map);
	public int updateLastChatDefault(String chat_list_id);
}
