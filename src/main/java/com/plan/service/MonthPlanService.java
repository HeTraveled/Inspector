package com.plan.service;

import com.home.model.User;
import com.plan.model.MonthPlan;
import com.util.page.PagedResult;

public interface MonthPlanService {
	
	Integer creatMonthPlan(MonthPlan monthPlan);
	
	PagedResult<MonthPlan> deptmonthplan(Integer did,Integer  years,Integer month,Integer pageNo,Integer pageSize);
	
	MonthPlan selectthismonth(int mid);
	//查询上月是否为空，因为本月计划任务是上月提交的
	MonthPlan selectmonth(int months,int years,Integer uid);
	
	int updateScore(MonthPlan monthPlan);
	
	PagedResult<MonthPlan> monthplanaudit(Integer did,Integer  years,Integer month,Integer pageNo,Integer pageSize);

	User selectrole(int uid);
	
	PagedResult<MonthPlan> monthplanauditleader(Integer did,Integer  years,Integer month,Integer pageNo,Integer pageSize);
	
	PagedResult<MonthPlan> monthplanauditcommon(Integer did,Integer  years,Integer month,Integer pageNo,Integer pageSize);
	
	Integer updateplan(MonthPlan monthPlan);
	
	
}
