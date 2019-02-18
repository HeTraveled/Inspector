package com.plan.service.impl;

import java.util.Date;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.plan.mapper.WeeksPlanNextMapper;
import com.plan.model.WeeksPlanNext;
import com.plan.service.WeeksPlanNextService;
import com.util.page.BeanUtil;
import com.util.page.PagedResult;

public class WeeksPlanNextImpl implements WeeksPlanNextService {

	private WeeksPlanNextMapper weeksPlanNextMapper;

	public WeeksPlanNextMapper getWeeksPlanNextMapper() {
		return weeksPlanNextMapper;
	}

	public void setWeeksPlanNextMapper(WeeksPlanNextMapper weeksPlanNextMapper) {
		this.weeksPlanNextMapper = weeksPlanNextMapper;
	}

	@Override
	public int creatweeksplannext(WeeksPlanNext weeksplannext) {
		
		return weeksPlanNextMapper.insertSelective(weeksplannext);
	}

	@Override
	public List<WeeksPlanNext> selectbynext(int wid) {
		
		return weeksPlanNextMapper.selectbynext(wid);
	}

	@Override
	public List<WeeksPlanNext> selectbythisweek(Date lastweekmonday,
			Date lastweeksunday) {
		
		return weeksPlanNextMapper.selectbythisweek(lastweekmonday,lastweeksunday);
	}

	@Override
	public int weeksplannextdelect(int id) {
		
		return weeksPlanNextMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int weeksplannextupdate(WeeksPlanNext weeksplannext) {
		
		return weeksPlanNextMapper.updateByPrimaryKeySelective(weeksplannext);
	}

	@Override
	public Integer weeksplannextinsert(List<WeeksPlanNext> weeksplannext) {
		
		return weeksPlanNextMapper.weeksplannextinsert(weeksplannext);
	}

	@Override
	public List<WeeksPlanNext> weeksplannextoverdue() {
		
		return weeksPlanNextMapper.weeksplannextoverdue();
	}

	@Override
	public Integer updateOverdue(List<Integer> id) {
	
		return weeksPlanNextMapper.updateOverdue(id);
	}

	@Override
	public List<Object> weeksEmergencyTop5(Integer did, Integer emergency) {
		return weeksPlanNextMapper.weeksEmergencyTop5(did, emergency);
	}

	@Override
	public PagedResult<Object> weeksEmergency(Integer did,
			Integer emergency, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null?1:pageNo;  
	    pageSize = pageSize == null?10:pageSize;  
    PageHelper.startPage(pageNo,pageSize);
    return BeanUtil.toPagedResult(weeksPlanNextMapper.weeksEmergency(did, emergency));
	}
}
