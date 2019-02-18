package com.plan.service.impl;

import com.github.pagehelper.PageHelper;
import com.plan.mapper.YearPlanMapper;
import com.plan.model.YearPlan;
import com.plan.service.YearPlanService;
import com.util.page.BeanUtil;
import com.util.page.PagedResult;

public class YearPlanImpl implements YearPlanService {
	private YearPlanMapper yearPlanMapper;

	public YearPlanMapper getYearPlanMapper() {
		return yearPlanMapper;
	}

	public void setYearPlanMapper(YearPlanMapper yearPlanMapper) {
		this.yearPlanMapper = yearPlanMapper;
	}

	@Override
	public YearPlan selectall(Integer years) {
		
		return yearPlanMapper.selectall(years);
	}

	@Override
	public PagedResult<YearPlan> selectlist(Integer years, Integer pageNo,
			Integer pageSize) {

		pageNo = pageNo == null?1:pageNo;  
	    pageSize = pageSize == null?10:pageSize;  
    PageHelper.startPage(pageNo,pageSize);
    return BeanUtil.toPagedResult(yearPlanMapper.selectlist(years));
	}

	@Override
	public Integer creatyearplan(YearPlan yearplan) {
		yearPlanMapper.insertSelective(yearplan);
		return yearplan.getYid();
	}

	@Override
	public YearPlan selectbykey(int yid) {
	
		return yearPlanMapper.selectByPrimaryKey(yid);
	}

	@Override
	public YearPlan selectlastyear(int year) {
		
		return yearPlanMapper.selectlastyear(year);
	}
	

}
