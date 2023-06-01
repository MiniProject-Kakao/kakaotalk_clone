package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Y_MemberService {
	
	@Autowired
	Y_MemberRepository repo;
	
	public int insertMember(Y_MemberDTO Y_MemberDTO) {
		return repo.insertMember(Y_MemberDTO);
	}

}
