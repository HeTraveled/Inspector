package com.inspector.service.impl;

import com.github.pagehelper.PageHelper;
import com.inspector.mapper.InspectorProgressMapper;
import com.inspector.model.InspectorProgress;
import com.inspector.service.InspectorProgressService;
import com.util.page.BeanUtil;
import com.util.page.PagedResult;

public class InspectorProgressImpl implements InspectorProgressService {

	private InspectorProgressMapper inspectorProgressMapper;

	public InspectorProgressMapper getInspectorProgressMapper() {
		return inspectorProgressMapper;
	}

	public void setInspectorProgressMapper(
			InspectorProgressMapper inspectorProgressMapper) {
		this.inspectorProgressMapper = inspectorProgressMapper;
	}

	@Override
	public Integer create(InspectorProgress inspectorProgress) {
		return inspectorProgressMapper.insertSelective(inspectorProgress);
	}

	@Override
	public PagedResult<InspectorProgress> selectiid(Integer iid,
			Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null?1:pageNo;  
	    pageSize = pageSize == null?10:pageSize;  
    PageHelper.startPage(pageNo,pageSize);
    return BeanUtil.toPagedResult(inspectorProgressMapper.selectiid(iid));
	}

	@Override
	public Integer selectDay(String time,String iid) {
		Integer num=inspectorProgressMapper.selectDay(time,iid);
		if(num!=null)return num;
		else return 0;
	}

	@Override
	public Integer delete(Integer iid) {
		return inspectorProgressMapper.delete(iid);
	}
	
	
}
