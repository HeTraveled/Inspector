package com.plan.service;

import java.util.List;

import com.plan.model.YearPlanNext;

public interface YearPlanNextService {

	List<YearPlanNext>	selectall(Integer mid);
	
	Integer creatyearplannext(List<YearPlanNext> yearplannext);
	
	List<YearPlanNext> selectbykey(Integer yid,Integer did);
	
	Integer yearplanupdate(int id);
	
	Integer yearplandelect(int id);
	
	List<YearPlanNext> selectbydept(Integer did,Integer yid);
	
	List<YearPlanNext> yearplannextoverdue();
	
	List<YearPlanNext> selectgroup(Integer yid);
}
