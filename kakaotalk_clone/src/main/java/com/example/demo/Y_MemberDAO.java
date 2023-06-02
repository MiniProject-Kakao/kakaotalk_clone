package com.example.demo;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Y_MemberDAO {
	
	public int insertmember(Y_MemberDTO Y_MemberDTO);

}
