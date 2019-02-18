package com.inspector.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.inspector.model.InspectorProgress;

public interface InspectorProgressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InspectorProgress record);

    int insertSelective(InspectorProgress record);

    InspectorProgress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InspectorProgress record);

    int updateByPrimaryKey(InspectorProgress record);
    
    List<InspectorProgress> selectiid(Integer iid);
    
	Integer selectDay(@Param("time") String time,@Param("iid") String iid);
	
	Integer delete(Integer iid);
}