package com.friend.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FriendDAO {
	public List<FriendResultDTO> getTotalFriend(String my_user_id);
	public UserDTO searchUser(String name,String phone);
	public void addFriend(String my_user_id,String friend_user_id);
	public void updateFollow(Boolean follow, String id);
	public FriendDTO checkFriend(String my_user_id,String friend_user_id);
	public UserDTO findUserById(String user_id);
	public List<FriendResultDTO> searchList(String my_user_id, String word);

}
