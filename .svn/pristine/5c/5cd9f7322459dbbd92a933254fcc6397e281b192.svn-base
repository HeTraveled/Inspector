package com.plan.service;

import java.util.List;

import com.plan.model.MonthPlanNext;
import com.util.page.PagedResult;

public interface MonthPlanNextService {

	Integer creatMonthPlanNext(List<MonthPlanNext> monthPlanNext);
	
	PagedResult<MonthPlanNext> selectall(Integer month,Integer pageNo,Integer pageSize);
	
	List<MonthPlanNext> selectthismonthsplan(int mid);
	
	Integer updatestate(int id,String remarks);
	
	List<MonthPlanNext> monthplannextoverdue();
	Integer updateOverdue(List<Integer> id);
	
	int monthplandelect(int id);
	
	
}
