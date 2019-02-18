package com.inspector.mapper;

import java.util.List;

import com.inspector.model.InspectorMessage;

public interface InspectorMessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InspectorMessage record);

    int insertSelective(InspectorMessage record);

    InspectorMessage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InspectorMessage record);

    int updateByPrimaryKey(InspectorMessage record);
    
    List<InspectorMessage> selectiid(Integer iid);
    
	List<InspectorMessage> selecttop3(Integer iid);
	
	Integer delete(Integer iid);
}