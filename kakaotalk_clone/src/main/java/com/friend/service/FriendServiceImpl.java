package com.friend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendServiceImpl implements FriendService {
	@Autowired
	FriendDAO dao;
	
	@Override
	public List<FriendResultDTO> getTotalFriend(String my_user_id) {
		return dao.getTotalFriend(my_user_id);
	}

	@Override
	public int addFreind(String name, String phone, String my_user_id) {
		UserDTO user = dao.searchUser(name, phone);
		if (user == null) {
			return 1;
		}
		
		FriendDTO check = dao.checkFriend(my_user_id, user.user_id);
		if (check == null) {
			dao.addFriend(my_user_id, user.user_id);
			return 0;
		} 
		return 2;
	}

	@Override
	public void updateFollow(Boolean follow, String id) {
		Boolean check;
		if (follow) check = false;
		else check = true;

		dao.updateFollow(check, id);
	}

	@Override
	public UserDTO findUserById(String user_id) {
		return dao.findUserById(user_id);
	}

	@Override
	public List<FriendResultDTO> searchList(String my_user_id, String word) {
		return dao.searchList(my_user_id, word);
	}

	@Override
	public void deleteFriend(String id) {
		dao.deleteFriend(id);
	}
	
	
}
