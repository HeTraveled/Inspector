package com.dept.service;

import java.util.List;

import com.dept.model.EmergencyRecord;
import com.util.page.PagedResult;

public interface EmergencyRecordSerivce {

	Integer create(EmergencyRecord emergencyRecord);
	
	List<Object> top5(Integer did,Integer emergency);
	
	PagedResult<Object> display(Integer did,Integer emergency,Integer pageNo,Integer pageSize);
	
	Integer delete(Integer id);
	
	EmergencyRecord selectid(Integer id);
	
	Integer update(EmergencyRecord emergencyRecord);
}
