package com.chat.chatlist;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

@Component
public class ChatListDTO {
	String chat_list_id;
	String last_content;
	String created_at, updated_at;
	String cr_name;
	String icon_url;
	UserJoinDTO user_join;
	
	public String getViewCreated_at(String created_at) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime ldt = LocalDateTime.parse(created_at, formatter);
		LocalDateTime now = LocalDateTime.now();
		String str = null;
		if (ldt.getYear() - now.getYear() < 0) {
			str = ldt.format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
		} else {
			if (now.getMonthValue() - ldt.getMonthValue() == 0 && now.getDayOfMonth() - ldt.getDayOfMonth() == 0) {
				str = ldt.format(DateTimeFormatter.ofPattern("a h:m"));
			} else {
				str = ldt.format(DateTimeFormatter.ofPattern("M월 d일"));
			}
		}
		return str;
		
	}
	
	public String getChat_list_id() {
		return chat_list_id;
	}
	public void setChat_list_id(String chat_list_id) {
		this.chat_list_id = chat_list_id;
	}
	public String getLast_content() {
		return last_content;
	}
	public void setLast_content(String last_content) {
		this.last_content = last_content;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = getViewCreated_at(updated_at);
	}
	public String getCr_name() {
		return cr_name;
	}
	public void setCr_name(String cr_name) {
		this.cr_name = cr_name;
	}
	public String getIcon_url() {
		return icon_url;
	}
	public void setIcon_url(String icon_url) {
		this.icon_url = icon_url;
	}
	public UserJoinDTO getUser_join() {
		return user_join;
	}
	public void setUser_join(UserJoinDTO user_join) {
		this.user_join = user_join;
	}
	@Override
	public String toString() {
		return "ChatListDTO [chat_list_id=" + chat_list_id + ", last_content=" + last_content + ", created_at="
				+ created_at + ", updated_at=" + updated_at + ", cr_name=" + cr_name + ", icon_url=" + icon_url
				+ ", user_join=" + user_join + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
