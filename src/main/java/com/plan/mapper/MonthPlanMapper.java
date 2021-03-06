package com.plan.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.home.model.User;
import com.plan.model.MonthPlan;

public interface MonthPlanMapper {
    int deleteByPrimaryKey(Integer mid);

    int insert(MonthPlan record);

    int insertSelective(MonthPlan record);

    MonthPlan selectByPrimaryKey(Integer mid);

    int updateByPrimaryKeySelective(MonthPlan monthPlan);
    
    int updateplan(MonthPlan monthPlan);

    int updateByPrimaryKey(MonthPlan record);
    
    List<MonthPlan> deptmonthplan(@Param("did")Integer did, @Param("years")Integer years,
    		@Param("month")Integer month);
    
    MonthPlan selectmonth(@Param("months")int months,@Param("years")int years,@Param("uid")Integer uid);
    
    List<MonthPlan> monthplanaudit(@Param("did")Integer did, @Param("years")Integer years,
    		@Param("month")Integer month);
    
    List<MonthPlan> monthplanauditleader(@Param("did")Integer did, @Param("years")Integer years,
    		@Param("month")Integer month);
    
    List<MonthPlan> monthplanauditcommon(@Param("did")Integer did, @Param("years")Integer years,
    		@Param("month")Integer month);
    //确定用户身份是否为领导
    User selectrole(@Param("uid")int uid);
}