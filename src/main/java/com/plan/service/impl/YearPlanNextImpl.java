package com.plan.service.impl;

import java.util.List;

import com.plan.mapper.YearPlanNextMapper;
import com.plan.model.YearPlanNext;
import com.plan.service.YearPlanNextService;

public class YearPlanNextImpl implements YearPlanNextService {
	
	private YearPlanNextMapper yearPlanNextMapper;

	public YearPlanNextMapper getYearPlanNextMapper() {
		return yearPlanNextMapper;
	}

	public void setYearPlanNextMapper(YearPlanNextMapper yearPlanNextMapper) {
		this.yearPlanNextMapper = yearPlanNextMapper;
	}

	@Override
	public List<YearPlanNext> selectall(Integer mid) {
	
		return yearPlanNextMapper.selectall(mid);
	}

	@Override
	public Integer creatyearplannext(List<YearPlanNext> yearplannext) {
		
		return yearPlanNextMapper.creatyearplannext(yearplannext);
	}

	@Override
	public List<YearPlanNext> selectbykey(Integer yid,Integer did) {
		
		return yearPlanNextMapper.selectbykey(yid,did);
	}

	@Override
	public Integer yearplanupdate(int id) {
		YearPlanNext yearPlanNext=new YearPlanNext();
		yearPlanNext.setId(id);
		yearPlanNext.setState(3);
		return yearPlanNextMapper.updateByPrimaryKeySelective(yearPlanNext);
	}

	@Override
	public Integer yearplandelect(int id) {
		
		return yearPlanNextMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<YearPlanNext> selectbydept(Integer did, Integer yid) {
		
		return yearPlanNextMapper.selectbydept(did, yid);
	}

	@Override
	public List<YearPlanNext> yearplannextoverdue() {
		
		return yearPlanNextMapper.yearplannextoverdue();
	}

	@Override
	public List<YearPlanNext> selectgroup(Integer yid) {
		
		return yearPlanNextMapper.selectgroup(yid);
	}

	

}
