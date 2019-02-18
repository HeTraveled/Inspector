package com.inspector.service.impl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.inspector.mapper.InspectorMessageMapper;
import com.inspector.model.InspectorMessage;
import com.inspector.service.InspectorMessageService;
import com.util.page.BeanUtil;
import com.util.page.PagedResult;

public class InspectorMessageImpl implements InspectorMessageService {

	private InspectorMessageMapper inspectorMessageMapper;

	public InspectorMessageMapper getInspectorMessageMapper() {
		return inspectorMessageMapper;
	}

	public void setInspectorMessageMapper(
			InspectorMessageMapper inspectorMessageMapper) {
		this.inspectorMessageMapper = inspectorMessageMapper;
	}

	@Override
	public Integer create(InspectorMessage inspectorMessage) {
		//在添加评论的同时需要推送给他人 
		
		return inspectorMessageMapper.insertSelective(inspectorMessage);
	}

	@Override
	public PagedResult<InspectorMessage> selectiid(Integer iid, Integer pageNo,
			Integer pageSize) {
		pageNo = pageNo == null?1:pageNo;  
	    pageSize = pageSize == null?10:pageSize;  
    PageHelper.startPage(pageNo,pageSize);
    return BeanUtil.toPagedResult(inspectorMessageMapper.selectiid(iid));
	}

	@Override
	public List<InspectorMessage> selecttop3(Integer iid) {
		return inspectorMessageMapper.selecttop3(iid);
	}

	@Override
	public Integer delete(Integer iid) {
		return inspectorMessageMapper.delete(iid);
	}
	
	
}
