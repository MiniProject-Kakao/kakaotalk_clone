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
	public MemberDTO LoginMember(String id) {
		return dao.LoginMember(id);
	}
	public int dupliemailcheck(String mail) {
		return dao.dupliemailcheck(mail);
	}
	public int dupliphonecheck(String phone) {
		return dao.dupliphonecheck(phone);
	}
	
}
