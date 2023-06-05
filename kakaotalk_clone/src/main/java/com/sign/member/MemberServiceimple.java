package com.sign.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberservice")

public class MemberServiceimple implements MemberService{
	
	@Autowired
	MemberDAO dao;
	
	public int insertMember(MemberDTO memberDTO) {
		return dao.insertMember(memberDTO);
	}

}
