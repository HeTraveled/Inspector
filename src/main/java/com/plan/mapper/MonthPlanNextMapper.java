package com.plan.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.plan.model.MonthPlanNext;

public interface MonthPlanNextMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MonthPlanNext record);

    int insertSelective(MonthPlanNext record);

    MonthPlanNext selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MonthPlanNext record);

    int updateByPrimaryKey(MonthPlanNext record);
    
    Integer creatMonthPlanNext(List<MonthPlanNext> monthPlanNext);
    
    List<MonthPlanNext> selectall(@Param("month")Integer month);
    
    List<MonthPlanNext>selectthismonthsplan(int mid);
    
    List<MonthPlanNext> monthplannextoverdue();
    
    Integer updateOverdue(List<Integer> id);
}