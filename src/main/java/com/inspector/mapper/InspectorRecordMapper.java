package com.inspector.mapper;

import java.util.List;

import com.inspector.model.InspectorRecord;

public interface InspectorRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InspectorRecord record);

    int insertSelective(InspectorRecord record);

    InspectorRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InspectorRecord record);

    int updateByPrimaryKey(InspectorRecord record);
    
    List<InspectorRecord> selectrecord(Integer iid);
    
	Integer delete(Integer iid);
}