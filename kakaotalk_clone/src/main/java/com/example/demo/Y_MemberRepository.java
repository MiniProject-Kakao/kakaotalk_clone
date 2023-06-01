package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Y_MemberRepository {
	
	@Autowired
	Y_MemberDAO dao;
	
	public int insertMember(Y_MemberDTO Y_MemberDTO) {
		return dao.insertmember(Y_MemberDTO);
	}

}
