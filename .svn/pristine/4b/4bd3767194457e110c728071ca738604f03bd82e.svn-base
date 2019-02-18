package com.inspector.service.impl;

import com.inspector.mapper.InspectorNameMapper;
import com.inspector.model.InspectorName;
import com.inspector.service.InspectorNameService;

public class InspectorNameImpl implements InspectorNameService {

	private InspectorNameMapper inspectorNameMapper;
	
	
	public InspectorNameMapper getInspectorNameMapper() {
		return inspectorNameMapper;
	}


	public void setInspectorNameMapper(InspectorNameMapper inspectorNameMapper) {
		this.inspectorNameMapper = inspectorNameMapper;
	}


	@Override
	public Integer create(InspectorName inspectorName) {
		return inspectorNameMapper.insertSelective(inspectorName);
	}


	@Override
	public Integer delete(Integer iid) {
		return inspectorNameMapper.delete(iid);
	}


	@Override
	public InspectorName selectid(Integer iid) {
		return inspectorNameMapper.selectid(iid);
	}

}
