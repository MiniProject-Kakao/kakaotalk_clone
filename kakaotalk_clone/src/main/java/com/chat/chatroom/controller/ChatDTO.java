package com.chat.chatroom.controller;

import org.springframework.stereotype.Component;

@Component
public class ChatDTO {
	String chat_id, chat_list_id, user_id;
	String created_at;
	String updated_at;
	String content;
	String type;
	String name;
	String profile_image;
	String cr_name;
	String icon_url;
	
	public String getChat_id() {
		return chat_id;
	}
	public void setChat_id(String chat_id) {
		this.chat_id = chat_id;
	}
	public String getChat_list_id() {
		return chat_list_id;
	}
	public void setChat_list_id(String chat_list_id) {
		this.chat_list_id = chat_list_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
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
		this.updated_at = updated_at;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfile_image() {
		return profile_image;
	}
	public void setProfile_image(String profile_image) {
		this.profile_image = profile_image;
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
	@Override
	public String toString() {
		return "ChatDTO [chat_id=" + chat_id + ", chat_list_id=" + chat_list_id + ", user_id=" + user_id
				+ ", created_at=" + created_at + ", updated_at=" + updated_at + ", content=" + content + ", type="
				+ type + ", name=" + name + ", profile_image=" + profile_image + ", cr_name=" + cr_name + ", icon_url="
				+ icon_url + "]";
	}
	
}
