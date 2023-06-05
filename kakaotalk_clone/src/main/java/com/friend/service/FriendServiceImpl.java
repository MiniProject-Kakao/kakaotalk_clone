package com.friend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendServiceImpl implements FriendService {
	@Autowired // 필요한 의존 객체의 “타입"에 해당하는 빈을 찾아 주입한다.(생성자, setter, 필드)
	FriendDAO dao;
	
	@Override
	public List<FriendDTO> getTotalFriend(String my_user_id) {
		return dao.getTotalFriend(my_user_id);
	}
	
}
