package com.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.sys.mapper.BugMapper;
import com.sys.model.Bug;
import com.sys.service.BugService;
import com.util.page.BeanUtil;
import com.util.page.PagedResult;

public class BugImpl implements BugService {

	private BugMapper bugMapper;

	public BugMapper getBugMapper() {
		return bugMapper;
	}

	public void setBugMapper(BugMapper bugMapper) {
		this.bugMapper = bugMapper;
	}

	@Override
	public PagedResult<Bug> display(Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null?1:pageNo;  
	    pageSize = pageSize == null?10:pageSize;  
    PageHelper.startPage(pageNo,pageSize);
    return BeanUtil.toPagedResult(bugMapper.display());
	}

	@Override
	public Integer create(Bug bug) {
		return bugMapper.insertSelective(bug);
	}
	
	
}
