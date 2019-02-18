package com.plan.service.impl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.home.model.User;
import com.plan.mapper.WeeksPlanMapper;
import com.plan.model.WeeksPlan;
import com.plan.service.WeeksPlanService;
import com.util.page.BeanUtil;
import com.util.page.PagedResult;

public class WeeksPlanImpl implements WeeksPlanService {

	private WeeksPlanMapper weeksPlanMapper;

	public WeeksPlanMapper getWeeksPlanMapper() {
		return weeksPlanMapper;
	}

	public void setWeeksPlanMapper(WeeksPlanMapper weeksPlanMapper) {
		this.weeksPlanMapper = weeksPlanMapper;
	}

	@Override
	public Integer creatweeksplan(WeeksPlan weeksplan) {
		weeksPlanMapper.insertSelective(weeksplan);
		return weeksplan.getWid();
	}

	@Override
	public PagedResult<WeeksPlan> selectall(Integer years,Integer weeks,Integer pageNo, Integer pageSize) {

		pageNo = pageNo == null?1:pageNo;  
	    pageSize = pageSize == null?10:pageSize;  
    PageHelper.startPage(pageNo,pageSize);
    return BeanUtil.toPagedResult(weeksPlanMapper.selectall(years,weeks));
	}

	

	@Override
	public WeeksPlan selectBywid(int wid) {
		// TODO Auto-generated method stub
		return weeksPlanMapper.selectByPrimaryKey(wid);
	}

	@Override
	public WeeksPlan selectlastweek(int uid,String year,int lastweek) {
		
		return weeksPlanMapper.selectlastweek(uid,year,lastweek);
	}

	@Override
	public PagedResult<WeeksPlan> weeksplanauditleader(int year, int month,int did,Integer pageNo, Integer pageSize) {
		
		pageNo = pageNo == null?1:pageNo;  
	    pageSize = pageSize == null?10:pageSize;  
    PageHelper.startPage(pageNo,pageSize);
    return 	BeanUtil.toPagedResult(weeksPlanMapper.weeksplanauditleader(year,month,did));
	}

	@Override
	public User selectrole(int uid) {
	
		return weeksPlanMapper.selectrole(uid);
	}

	@Override
	public PagedResult<WeeksPlan> weeksplanauditcommon(int did, Integer pageNo,
			Integer pageSize) {
		pageNo = pageNo == null?1:pageNo;  
	    pageSize = pageSize == null?10:pageSize;  
    PageHelper.startPage(pageNo,pageSize);
    return 	BeanUtil.toPagedResult(weeksPlanMapper.selectcommon(did));
	}

	@Override
	public WeeksPlan selectweekdept(int did, int years, int weeks) {
		
		return weeksPlanMapper.selectweekdept(did, years, weeks);
	}

	@Override
	public List<User> selectdeptsize(int did) {
		
		return weeksPlanMapper.selectdeptsize(did);
	}


	@Override
	public List<WeeksPlan> selectall2(Integer years, Integer weeks) {
	
		return weeksPlanMapper.selectall(years, weeks);
	}


	@Override
	public List<WeeksPlan> selectEme(int year, int month, int week) {
		return weeksPlanMapper.selectEme(year, month, week);
	}	

	@Override
	public List<WeeksPlan> selectlist() {
	
		return weeksPlanMapper.selectlist();
	}

	@Override
	public List<WeeksPlan> selectdeptcommon(Integer years, Integer weeks,
			Integer did) {
		// TODO Auto-generated method stub
		return weeksPlanMapper.selectdeptcommon(years, weeks,did);
	}

	

		
	
}
