package com.chat.chatroom.controller;

import org.springframework.web.multipart.MultipartFile;

public class UploadDTO {
	MultipartFile file1;
	String user_id, type, content, chat_list_id;

	public MultipartFile getFile1() {
		return file1;
	}
	public void setFile1(MultipartFile file1) {
		this.file1 = file1;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getChat_list_id() {
		return chat_list_id;
	}
	public void setChat_list_id(String chat_list_id) {
		this.chat_list_id = chat_list_id;
	}
	@Override
	public String toString() {
		return "UploadDTO [file1=" + file1 + ", user_id=" + user_id + ", type=" + type + ", content=" + content
				+ ", chat_list_id=" + chat_list_id + "]";
	}
	
	

}
