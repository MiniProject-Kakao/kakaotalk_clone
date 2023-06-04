package com.friend.service;

public class FriendResultDTO {
	String id;
	UserDTO my_user_id, friend_user_id;
	boolean follow;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public UserDTO getMy_user_id() {
		return my_user_id;
	}
	public void setMy_user_id(UserDTO my_user_id) {
		this.my_user_id = my_user_id;
	}
	public UserDTO getFriend_user_id() {
		return friend_user_id;
	}
	public void setFriend_user_id(UserDTO friend_user_id) {
		this.friend_user_id = friend_user_id;
	}
	public boolean isFollow() {
		return follow;
	}
	public void setFollow(boolean follow) {
		this.follow = follow;
	}
}
