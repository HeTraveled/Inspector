package com.dept.service.Impl;

import java.util.List;

import com.dept.mapper.EmergencyRecordMapper;
import com.dept.model.EmergencyRecord;
import com.dept.service.EmergencyRecordSerivce;
import com.github.pagehelper.PageHelper;
import com.util.page.BeanUtil;
import com.util.page.PagedResult;

public class EmergencyRecordImpl implements EmergencyRecordSerivce {

	private EmergencyRecordMapper emergencyRecordMapper;

	public EmergencyRecordMapper getEmergencyRecordMapper() {
		return emergencyRecordMapper;
	}

	public void setEmergencyRecordMapper(EmergencyRecordMapper emergencyRecordMapper) {
		this.emergencyRecordMapper = emergencyRecordMapper;
	}

	@Override
	public Integer create(EmergencyRecord emergencyRecord) {
		emergencyRecordMapper.insertSelective(emergencyRecord);
		return emergencyRecord.getId();
	}

	@Override
	public List<Object> top5(Integer did, Integer emergency) {
		return emergencyRecordMapper.top5(did, emergency);
	}

	@Override
	public PagedResult<Object> display(Integer did, Integer emergency,
			Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null?1:pageNo;  
	    pageSize = pageSize == null?10:pageSize;  
    PageHelper.startPage(pageNo,pageSize);
    return BeanUtil.toPagedResult(emergencyRecordMapper.display(did, emergency));
	}

	@Override
	public Integer delete(Integer id) {
		return emergencyRecordMapper.deleteByPrimaryKey(id);
	}

	@Override
	public EmergencyRecord selectid(Integer id) {
		return emergencyRecordMapper.selectByPrimaryKey(id);
	}

	@Override
	public Integer update(EmergencyRecord emergencyRecord) {
		return emergencyRecordMapper.updateByPrimaryKeySelective(emergencyRecord);
	}
	
	
 }
