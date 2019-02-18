package com.plan.service.impl;

import com.github.pagehelper.PageHelper;
import com.home.model.User;
import com.plan.mapper.MonthPlanMapper;
import com.plan.model.MonthPlan;
import com.plan.service.MonthPlanService;
import com.util.page.BeanUtil;
import com.util.page.PagedResult;

public class MonthPlanImpl implements MonthPlanService {

	private MonthPlanMapper monthPlanMapper;

	public MonthPlanMapper getMonthPlanMapper() {
		return monthPlanMapper;
	}

	public void setMonthPlanMapper(MonthPlanMapper monthPlanMapper) {
		this.monthPlanMapper = monthPlanMapper;
	}

	@Override
	public Integer creatMonthPlan(MonthPlan monthPlan) {
		monthPlanMapper.insertSelective(monthPlan);
		return monthPlan.getMid();
	}

	@Override
	public PagedResult<MonthPlan> deptmonthplan(Integer did, Integer years,
			Integer month, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null?1:pageNo;  
	    pageSize = pageSize == null?10:pageSize;  
    PageHelper.startPage(pageNo,pageSize);
    return BeanUtil.toPagedResult(monthPlanMapper.deptmonthplan(did,years,month));
	}

	@Override
	public MonthPlan selectthismonth(int mid) {
		
		return monthPlanMapper.selectByPrimaryKey(mid);
	}

	@Override
	public MonthPlan selectmonth(int months,int years,Integer uid) {
	
		return monthPlanMapper.selectmonth(months,years,uid);
	}

	@Override
	public int updateScore(MonthPlan monthPlan) {
	
		return monthPlanMapper.updateByPrimaryKeySelective(monthPlan);
	}

	@Override
	public PagedResult<MonthPlan> monthplanaudit(Integer did,Integer years,
			Integer month, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null?1:pageNo;  
	    pageSize = pageSize == null?10:pageSize;  
    PageHelper.startPage(pageNo,pageSize);
    return BeanUtil.toPagedResult(monthPlanMapper.monthplanaudit(did,years,month));
	}

	@Override
	public User selectrole(int uid) {
	
		return monthPlanMapper.selectrole(uid);
	}

	@Override
	public PagedResult<MonthPlan> monthplanauditleader(Integer did,Integer years,
			Integer month, Integer pageNo, Integer pageSize) {
		// 	Integer month, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null?1:pageNo;  
	    pageSize = pageSize == null?10:pageSize;  
    PageHelper.startPage(pageNo,pageSize);
    return BeanUtil.toPagedResult(monthPlanMapper.monthplanauditleader(did,years,month));
	
	}

	@Override
	public PagedResult<MonthPlan> monthplanauditcommon(Integer did,
			Integer years, Integer month, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null?1:pageNo;  
	    pageSize = pageSize == null?10:pageSize;  
    PageHelper.startPage(pageNo,pageSize);
    return BeanUtil.toPagedResult(monthPlanMapper.monthplanauditcommon(did,years,month));
	}

	@Override
	public Integer updateplan(MonthPlan monthPlan) {
		
		return monthPlanMapper.updateplan(monthPlan);
	}

	
	
	
}
