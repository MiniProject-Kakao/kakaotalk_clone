package com.chat.chatlist;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

@Component
public class UserJoinDTO {
	String join_id, user_id, chat_list_id;
	Timestamp created_at;
	
	public String getJoin_id() {
		return join_id;
	}
	public void setJoin_id(String join_id) {
		this.join_id = join_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getChat_list_id() {
		return chat_list_id;
	}
	public void setChat_list_id(String chat_list_id) {
		this.chat_list_id = chat_list_id;
	}
	public Timestamp getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	@Override
	public String toString() {
		return "UserJoinDTO [join_id=" + join_id + ", user_id=" + user_id + ", chat_list_id=" + chat_list_id
				+ ", created_at=" + created_at + "]";
	}
	
	

}
