package com.plan.service;

import java.util.List;

import com.home.model.User;
import com.plan.model.WeeksPlan;
import com.util.page.PagedResult;

public interface WeeksPlanService {
	
	Integer creatweeksplan(WeeksPlan weeksplan);


	PagedResult<WeeksPlan> selectall(Integer years,Integer weeks,Integer pageNo,Integer pageSize);

	WeeksPlan selectBywid(int wid);
	
	WeeksPlan selectlastweek(int uid,String year,int lastweek);
	
	PagedResult<WeeksPlan> weeksplanauditleader(int year,int month,int did,Integer pageNo,Integer pageSize);
	
	User selectrole(int uid);
	
	PagedResult<WeeksPlan> weeksplanauditcommon(int did,Integer pageNo,Integer pageSize);
	
	//查询本周本部门是否已经提交计划
	WeeksPlan selectweekdept(int did ,int years,int weeks);
	
	List<User> selectdeptsize(int did);

	
	List<WeeksPlan> selectall2(Integer years,Integer weeks);

	
	//部门看板
	List<WeeksPlan> selectEme(int year,int month,int week);
	//计划汇总查询
	List<WeeksPlan> selectlist();
	List<WeeksPlan> selectdeptcommon(Integer years,Integer weeks,Integer did);
	
	
	

}
