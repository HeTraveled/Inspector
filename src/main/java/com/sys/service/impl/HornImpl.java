package com.sys.service.impl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.sys.mapper.HornMapper;
import com.sys.model.Horn;
import com.sys.service.HornService;
import com.util.page.BeanUtil;
import com.util.page.PagedResult;

public class HornImpl implements HornService {

	private HornMapper hornMapper;

	public HornMapper getHornMapper() {
		return hornMapper;
	}

	public void setHornMapper(HornMapper hornMapper) {
		this.hornMapper = hornMapper;
	}

	@Override
	public Integer create(Horn horn) {
		return hornMapper.insertSelective(horn);
	}

	@Override
	public Integer update(Horn horn) {
		return hornMapper.updateByPrimaryKeySelective(horn);
	}

	@Override
	public Integer delete(Integer id) {
		return hornMapper.deleteByPrimaryKey(id);
	}

	@Override
	public PagedResult<Horn> display(Horn horn, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null?1:pageNo;  
	    pageSize = pageSize == null?10:pageSize;  
    PageHelper.startPage(pageNo,pageSize);
    return BeanUtil.toPagedResult(hornMapper.display(horn));
	}

	@Override
	public Horn selectid(Integer id) {
		return hornMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Horn> select24H() {
		return hornMapper.select24H();
	}

	@Override
	public Integer deletes(List<Integer> id) {
		return hornMapper.deletes(id);
	}
	
	
}
