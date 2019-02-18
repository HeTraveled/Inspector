package com.dept.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dept.model.Emergency;

public interface EmergencyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Emergency record);

    int insertSelective(Emergency record);

    Emergency selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Emergency record);

    int updateByPrimaryKey(Emergency record);
    
	Integer creates(List<Emergency> emergencies);
	
	Integer update(Emergency emergency);
	
	Integer delWeek();
	
	Integer delete(Emergency emergency);
	
	Integer deleteins(@Param("id") Integer id);
}