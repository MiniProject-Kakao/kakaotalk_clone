package com.chat.chatroom.controller;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ChatDAO {
	public List<ChatDTO> getMonthChat(String chat_list_id);
}
