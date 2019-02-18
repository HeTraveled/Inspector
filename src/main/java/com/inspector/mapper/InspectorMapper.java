package com.inspector.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.inspector.model.Inspector;

public interface InspectorMapper {
    int deleteByPrimaryKey(Integer iid);

    int insert(Inspector record);

    int insertSelective(Inspector record);

    Inspector selectByPrimaryKey(Integer iid);

    int updateByPrimaryKeySelective(Inspector record);

    int updateByPrimaryKey(Inspector record);
    
    List<Inspector> display(Inspector inspector);

	List<Inspector> homePageTop6(Inspector inspector);
	
	Integer progressNum(Inspector inspector);
	
	Integer expireNum(Inspector inspector);
	
	Integer state(@Param("state") Integer state,@Param("iid") Integer iid);
	
	List<Inspector> overdue();

	Integer updateOverdue(List<Integer> iid);
	
	List<Inspector> feedback(@Param("frequency") Integer frequency);
	
	List<Object> insEmergency(@Param("did") Integer did,@Param("emergency") Integer emergency);
	
	List<Object> insEmergencyTop5(@Param("did") Integer did,@Param("emergency") Integer emergency);
	
}