package com.inspector.mapper;

import com.inspector.model.InspectorName;

public interface InspectorNameMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InspectorName record);

    int insertSelective(InspectorName record);

    InspectorName selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InspectorName record);

    int updateByPrimaryKey(InspectorName record);
    
	Integer delete(Integer iid);
	
	InspectorName selectid(Integer iid);
}