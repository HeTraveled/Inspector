package com.inspector.service.impl;

import com.github.pagehelper.PageHelper;
import com.inspector.mapper.InspectorRecordMapper;
import com.inspector.model.InspectorRecord;
import com.inspector.service.InspectorRecordService;
import com.util.page.BeanUtil;
import com.util.page.PagedResult;

public class InspectorRecordImpl implements InspectorRecordService {

	private InspectorRecordMapper inspectorRecordMapper;

	public InspectorRecordMapper getInspectorRecordMapper() {
		return inspectorRecordMapper;
	}

	public void setInspectorRecordMapper(InspectorRecordMapper inspectorRecordMapper) {
		this.inspectorRecordMapper = inspectorRecordMapper;
	}

	@Override
	public PagedResult<InspectorRecord> selectiid(Integer iid, Integer pageNo,
			Integer pageSize) {
		pageNo = pageNo == null?1:pageNo;  
	    pageSize = pageSize == null?10:pageSize;  
    PageHelper.startPage(pageNo,pageSize);
    return BeanUtil.toPagedResult(inspectorRecordMapper.selectrecord(iid));
	}

	@Override
	public Integer delete(Integer iid) {
		return inspectorRecordMapper.delete(iid);
	}
	
	
}
