package com.sys.service.impl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.sys.mapper.SloganMapper;
import com.sys.model.Slogan;
import com.sys.service.SloganService;
import com.util.page.BeanUtil;
import com.util.page.PagedResult;

public class SloganImpl implements SloganService {

	private SloganMapper sloganMapper;
	
	
	public SloganMapper getSloganMapper() {
		return sloganMapper;
	}

	public void setSloganMapper(SloganMapper sloganMapper) {
		this.sloganMapper = sloganMapper;
	}

	@Override
	public Integer create(Slogan slogan) {
		return sloganMapper.insertSelective(slogan);
	}

	@Override
	public Integer update(Slogan slogan) {
		return sloganMapper.updateByPrimaryKeySelective(slogan);
	}

	@Override
	public Integer deletes(List<Integer> id) {
		return sloganMapper.deletes(id);
	}

	@Override
	public Slogan random() {
		return sloganMapper.random();
	}

	@Override
	public Slogan selectid(Integer id) {
		return sloganMapper.selectByPrimaryKey(id);
	}

	@Override
	public PagedResult<Slogan> display(Slogan slogan, Integer pageNo,
			Integer pageSize) {
		pageNo = pageNo == null?1:pageNo;  
	    pageSize = pageSize == null?10:pageSize;  
    PageHelper.startPage(pageNo,pageSize);
    return BeanUtil.toPagedResult(sloganMapper.display(slogan));
	}
@Override
public Integer first(Integer id) {
	return sloganMapper.first(id);
}

@Override
public Integer updaterandom() {
	return sloganMapper.updaterandom();
}

@Override
public Slogan randomNum() {
	return sloganMapper.randomNum();
}

}
