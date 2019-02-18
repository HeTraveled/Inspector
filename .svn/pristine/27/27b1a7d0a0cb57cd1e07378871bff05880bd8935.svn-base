package com.plan.mapper;

import java.util.List;

import com.plan.model.MonthPlanMessage;

public interface MonthPlanMessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MonthPlanMessage record);

    int insertSelective(MonthPlanMessage monthPlanMessage);

    MonthPlanMessage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MonthPlanMessage record);

    int updateByPrimaryKey(MonthPlanMessage record);
    
    List<MonthPlanMessage> selectMessage(Integer mid);
    
    List<MonthPlanMessage> selectMessageAll(Integer mid);
}