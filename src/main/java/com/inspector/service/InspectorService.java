package com.inspector.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.inspector.model.Inspector;
import com.util.page.PagedResult;

public interface InspectorService {

	Integer create(Inspector inspector);
	
	PagedResult<Inspector> display(Inspector inspector,Integer pageNo,Integer pageSize);
	
	Inspector selectid(Integer iid);
	
	Integer update(Inspector inspector,HttpServletRequest request);
	
	Integer delete(Integer iid);
	
	Integer state(Integer state,Integer iid);
	
	List<Inspector> homePageTop6(Inspector inspector);
	
	PagedResult<Inspector> homePage(Inspector inspector,Integer pageNo,Integer pageSize);
	
	Integer progressNum(Inspector inspector);
	
	Integer expireNum(Inspector inspector);
	
	Integer update(Inspector inspector);
	
	List<Inspector> overdue();
	
	Integer updateOverdue(List<Integer> iid);
	
	List<Inspector> feedback(Integer frequency);
	
	PagedResult<Object> insEmergency(Integer did,Integer emergency,Integer pageNo,Integer pageSize);
	
	List<Object> insEmergencyTop5(Integer did,Integer emergency);
	
}
