package com.sign.member;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MemberDAO {
	
	public int insertMember(MemberDTO memberDTO);
	public MemberDTO LoginMember(String id);
	public int dupliemailcheck(String mail);
	public int dupliphonecheck(String phone);
}
