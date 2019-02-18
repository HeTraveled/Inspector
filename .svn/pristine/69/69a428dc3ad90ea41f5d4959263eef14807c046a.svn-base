package com.dept.service.Impl;

import java.util.List;

import com.dept.mapper.EmergencyMapper;
import com.dept.model.Emergency;
import com.dept.service.EmergencyService;

public class EmergencyImpl implements EmergencyService {

	private EmergencyMapper emergencyMapper;

	public EmergencyMapper getEmergencyMapper() {
		return emergencyMapper;
	}

	public void setEmergencyMapper(EmergencyMapper emergencyMapper) {
		this.emergencyMapper = emergencyMapper;
	}

	@Override
	public Integer creates(List<Emergency> emergencies) {
		return emergencyMapper.creates(emergencies);
	}

	@Override
	public Integer update(Emergency emergency) {
		return emergencyMapper.update(emergency);
	}

	@Override
	public Integer delWeek() {
		return emergencyMapper.delWeek();
	}

	@Override
	public Integer create(Emergency emergency) {
		return emergencyMapper.insertSelective(emergency);
	}

	@Override
	public Integer delete(Emergency emergency) {
		return emergencyMapper.delete(emergency);
	}

	@Override
	public Integer deleteins(Integer id) {
		return emergencyMapper.deleteins(id);
	}
	
	
}
