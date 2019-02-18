package com.plan.service;

import java.util.Date;
import java.util.List;

import com.plan.model.WeeksPlanNext;
import com.util.page.PagedResult;

public interface WeeksPlanNextService {
	int creatweeksplannext(WeeksPlanNext weeksplannext);
	
	List<WeeksPlanNext> selectbynext(int wid); 
	
	List<WeeksPlanNext>selectbythisweek(Date lastweekmonday,Date lastweeksunday);
	
	int weeksplannextdelect(int id);
	
	int weeksplannextupdate(WeeksPlanNext weeksplannext );
	
	Integer weeksplannextinsert( List<WeeksPlanNext> weeksplannext);
	
	List<WeeksPlanNext> weeksplannextoverdue();
	Integer updateOverdue(List<Integer> id);
	
	//部门看板前5
	List<Object> weeksEmergencyTop5(Integer did,Integer emergency);
	PagedResult<Object> weeksEmergency(Integer did,Integer emergency,Integer pageNo,Integer pageSize);
}
