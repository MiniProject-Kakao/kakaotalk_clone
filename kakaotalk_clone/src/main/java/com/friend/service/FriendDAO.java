package com.friend.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper // sql을 메소드로 쓰기 위해, sql 결과를 정의해놓은 모델로 매핑하기 위함
@Repository // 매퍼들을 포함해서 mapper처럼 sql을 메소드랑 매핑해서 쓰든 아니든 db를 조회 및 조작하는 것에 중점을 둠
//repository(dao)는 비즈니스로직에서 db의 데이터를 조회 및 조작하는 것을 비즈니스 로직과 분리하기 위한 것
public interface FriendDAO {
	public List<FriendDTO> getTotalFriend(String my_user_id);
}
