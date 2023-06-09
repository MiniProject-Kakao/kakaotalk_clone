package com.menu.more;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
//내용추가
@Mapper
public interface MoreDAO {
    public void insertMember(MoreDTO MoreDTO);
    
    public MoreDTO selectByPhone(String phone); 
    
    public MoreDTO selectUserById(String id);
    
    public int updateDeletedAt(@Param("userId") String userId, @Param("deletedAt") String deletedAt); 
    
    public MoreDTO selectByUsername(String username);

    public void updateMember(MoreDTO bMoreDTO);
    
    public int updateUserStatus(MoreDTO bMoreDTO);
    
    public void updateUsername(@Param("phone") String phone, @Param("username") String username);

    public void updateStatusMessage(@Param("phone") String phone, @Param("statusMessage") String statusMessage);
}
    
    