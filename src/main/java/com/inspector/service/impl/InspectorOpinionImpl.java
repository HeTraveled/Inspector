package com.inspector.service.impl;

import com.github.pagehelper.PageHelper;
import com.inspector.mapper.InspectorOpinionMapper;
import com.inspector.model.InspectorOpinion;
import com.inspector.service.InspectorOpinionService;
import com.util.page.BeanUtil;
import com.util.page.PagedResult;

public class InspectorOpinionImpl implements InspectorOpinionService {

	private InspectorOpinionMapper inspectorOpinionMapper;

	public InspectorOpinionMapper getInspectorOpinionMapper() {
		return inspectorOpinionMapper;
	}

	public void setInspectorOpinionMapper(
			InspectorOpinionMapper inspectorOpinionMapper) {
		this.inspectorOpinionMapper = inspectorOpinionMapper;
	}

	@Override
	public Integer create(InspectorOpinion inspectorOpinion) {
		return inspectorOpinionMapper.insertSelective(inspectorOpinion);
	}

	@Override
	public PagedResult<InspectorOpinion> selectiid(Integer iid, Integer pageNo,
			Integer pageSize) {
		pageNo = pageNo == null?1:pageNo;  
	    pageSize = pageSize == null?10:pageSize;  
    PageHelper.startPage(pageNo,pageSize);
    return BeanUtil.toPagedResult(inspectorOpinionMapper.selectiid(iid));
	}

	@Override
	public Integer delete(Integer iid) {
		return inspectorOpinionMapper.delete(iid);
	}
	
	
}
