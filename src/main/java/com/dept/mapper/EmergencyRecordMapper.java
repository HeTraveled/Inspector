package com.dept.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dept.model.EmergencyRecord;

public interface EmergencyRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EmergencyRecord record);

    int insertSelective(EmergencyRecord record);

    EmergencyRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EmergencyRecord record);

    int updateByPrimaryKey(EmergencyRecord record);
    
	List<Object> top5(@Param("did") Integer did,@Param("emergency") Integer emergency);
	
	List<Object> display(@Param("did") Integer did,@Param("emergency") Integer emergency);
}