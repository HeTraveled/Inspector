package com.sys.service.impl;

import java.util.Date;

import com.sys.mapper.PropellingMapper;
import com.sys.model.Propelling;
import com.sys.service.PropellingService;

public class PropellingImpl implements PropellingService {

	private PropellingMapper propellingMapper;

	public PropellingMapper getPropellingMapper() {
		return propellingMapper;
	}

	public void setPropellingMapper(PropellingMapper propellingMapper) {
		this.propellingMapper = propellingMapper;
	}

	@Override
	public Integer update(String propelling) {
		return propellingMapper.update(propelling);
	}

	@Override
	public Propelling selectid() {
		return propellingMapper.selectid();
	}

	@Override
	public String select() {
		Date PropellingTime=propellingMapper.selectid().getPropellingTime();
		System.out.println(1123123243);
		return "0 "+PropellingTime.getMinutes()+" "+PropellingTime.getHours()+" * * ?";
	}
	
	
}
