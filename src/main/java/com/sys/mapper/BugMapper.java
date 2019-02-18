package com.sys.mapper;

import java.util.List;

import com.sys.model.Bug;

public interface BugMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Bug record);

    int insertSelective(Bug record);

    Bug selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Bug record);

    int updateByPrimaryKey(Bug record);
    
    List<Bug> display();
}