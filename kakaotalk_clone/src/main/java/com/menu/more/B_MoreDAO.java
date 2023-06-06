package com.menu.more;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface B_MoreDAO {
    public int insertMember(B_MoreDTO B_MoreDTO);
    
    public void updateDeletedAt(@Param("phone") String phone, @Param("deletedAt") String deletedAt);
}