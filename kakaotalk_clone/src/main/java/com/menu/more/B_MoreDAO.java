package com.menu.more;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface B_MoreDAO {
    public void insertMember(B_MoreDTO B_MoreDTO);
    
    public B_MoreDTO selectByPhone(String phone); 
    
    public int updateDeletedAt(@Param("phone") String phone, @Param("deletedAt") String deletedAt); 
    
    public B_MoreDTO selectByUsername(String username);

    public void updateMember(B_MoreDTO bMoreDTO);
    
    public int updateUserStatus(B_MoreDTO bMoreDTO);
    }