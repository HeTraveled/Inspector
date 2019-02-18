package com.sys.service.impl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.sys.mapper.RegulationsMapper;
import com.sys.model.Regulations;
import com.sys.service.RegulationsService;
import com.util.page.BeanUtil;
import com.util.page.PagedResult;

public class RegulationsImpl implements RegulationsService {

	private RegulationsMapper regulationsMapper;

	public RegulationsMapper getRegulationsMapper() {
		return regulationsMapper;
	}

	public void setRegulationsMapper(RegulationsMapper regulationsMapper) {
		this.regulationsMapper = regulationsMapper;
	}

	@Override
	public Integer create(Regulations regulations) {
		regulationsMapper.insertSelective(regulations);
		return regulations.getId();
	}

	@Override
	public Integer update(Regulations regulations) {
		return regulationsMapper.updateByPrimaryKeySelective(regulations);
	}

	@Override
	public Integer delete(Integer id) {
		return regulationsMapper.deleteByPrimaryKey(id);
	}

	@Override
	public PagedResult<Regulations> display(Regulations regulations,
			Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null?1:pageNo;  
	    pageSize = pageSize == null?10:pageSize;  
    PageHelper.startPage(pageNo,pageSize);
    return BeanUtil.toPagedResult(regulationsMapper.display(regulations));
	}

	@Override
	public Regulations selectid(Integer id) {
		return regulationsMapper.selectByPrimaryKey(id);
	}

	@Override
	public Integer regulationNum() {
		return regulationsMapper.regulationNum();
	}

	@Override
	public Integer deletes(List<Integer> id) {
		return regulationsMapper.deletes(id);
	}

	
}
