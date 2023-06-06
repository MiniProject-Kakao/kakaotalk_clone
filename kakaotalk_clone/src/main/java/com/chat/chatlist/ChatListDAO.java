package com.chat.chatlist;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ChatListDAO {
	public List<ChatListDTO> getAllChatList(String user_id);
	public int updateLastChat(ChatListDTO dto);
}
