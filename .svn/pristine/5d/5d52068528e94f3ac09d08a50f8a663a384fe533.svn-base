package com.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sys.model.MessageRemind;

public interface MessageRemindMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MessageRemind record);

    int insertSelective(MessageRemind record);

    MessageRemind selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MessageRemind record);

    int updateByPrimaryKey(MessageRemind record);
    
	Integer unreadNum(Integer uid);
	
	MessageRemind selectid(@Param("id") Integer id,@Param("uid") Integer uid);
	
	List<MessageRemind> selectTop5(Integer uid);
	
	Integer selectNum(Integer uid);
	
	Integer deletes(List<Integer> id);
	
	Integer empty(Integer uid);
	
	Integer batchflag(List<Integer> id);
	
	Integer creates(List<MessageRemind> messageReminds);
}