package com.friend.service;

import java.util.List;

public interface FriendService {
	public List<FriendResultDTO> getTotalFriend(String my_user_id);
	public int addFreind(String name, String phone,String my_user_id);
	public void updateFollow(Boolean follow, String id);
	public UserDTO findUserById(String user_id);
	public List<FriendResultDTO> searchList(String my_user_id, String word);
	public void deleteFriend(String id);
}
