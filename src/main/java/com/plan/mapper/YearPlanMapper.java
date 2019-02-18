package com.plan.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.plan.model.YearPlan;

public interface YearPlanMapper {
    int deleteByPrimaryKey(Integer yid);

    int insert(YearPlan record);

    int insertSelective(YearPlan record);

    YearPlan selectByPrimaryKey(Integer yid);

    int updateByPrimaryKeySelective(YearPlan record);

    int updateByPrimaryKey(YearPlan record);
    
    YearPlan selectall(@Param("years")Integer years);
    
    List<YearPlan> selectlist(@Param("years")Integer years);
    
    YearPlan selectlastyear(@Param("year")int year);
    
    
}