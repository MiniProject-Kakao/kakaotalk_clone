package com.sign.member;

public interface MemberService {
	
	public int insertMember(MemberDTO memberDTO);
	public MemberDTO LoginMember(String id);
	public int dupliemailcheck(String mail);
	public int dupliphonecheck(String phone);
}
