package com.plan.service.impl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.plan.mapper.MonthPlanMessageMapper;
import com.plan.model.MonthPlanMessage;
import com.plan.service.MonthPlanMessageService;
import com.util.page.BeanUtil;
import com.util.page.PagedResult;

public class MonthPlanMessageImpl implements MonthPlanMessageService {

	private MonthPlanMessageMapper monthPlanMessageMapper;

	public MonthPlanMessageMapper getMonthPlanMessageMapper() {
		return monthPlanMessageMapper;
	}

	public void setMonthPlanMessageMapper(
			MonthPlanMessageMapper monthPlanMessageMapper) {
		this.monthPlanMessageMapper = monthPlanMessageMapper;
	}

	@Override
	public Integer creatMessage(MonthPlanMessage monthPlanMessage) {
		
		return monthPlanMessageMapper.insertSelective(monthPlanMessage);
	}

	@Override
	public List<MonthPlanMessage> selectMessage(Integer mid) {
		
		return monthPlanMessageMapper.selectMessage(mid);
	}

	@Override
	public PagedResult<MonthPlanMessage> selectall(Integer wid, Integer pageNo,
			Integer pageSize) {
		pageNo = pageNo == null?1:pageNo;  
	    pageSize = pageSize == null?10:pageSize;  
    PageHelper.startPage(pageNo,pageSize);
    return BeanUtil.toPagedResult(monthPlanMessageMapper.selectMessageAll(wid));
	}
	

	
	
	
}
