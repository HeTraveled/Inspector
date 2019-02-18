package com.wechat.mapper;

import org.apache.ibatis.annotations.Param;

import com.wechat.model.Token;

public interface TokenMapper {
    int deleteByPrimaryKey(String token);

    int insert(Token record);

    int insertSelective(Token record);
    
    Token display();
    
	Integer update(@Param("token") String token);
}