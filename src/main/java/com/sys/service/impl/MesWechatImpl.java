package com.sys.service.impl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.sys.mapper.MesWechatMapper;
import com.sys.model.MesWechat;
import com.sys.service.MesWechatService;
import com.util.page.BeanUtil;
import com.util.page.PagedResult;

public class MesWechatImpl implements MesWechatService {

	private MesWechatMapper mesWechatMapper;

	public MesWechatMapper getMesWechatMapper() {
		return mesWechatMapper;
	}

	public void setMesWechatMapper(MesWechatMapper mesWechatMapper) {
		this.mesWechatMapper = mesWechatMapper;
	}

	@Override
	public Integer deletes(List<Integer> id) {
		return mesWechatMapper.deletes(id);
	}

	@Override
	public Integer create(MesWechat mesWechat) {
		mesWechatMapper.insertSelective(mesWechat);
		return mesWechat.getId();
	}

	@Override
	public MesWechat selectid(Integer id) {
		return mesWechatMapper.selectByPrimaryKey(id);
	}

	@Override
	public PagedResult<MesWechat> display(MesWechat mesWechat, Integer pageNo,
			Integer pageSize) {
		pageNo = pageNo == null?1:pageNo;  
	    pageSize = pageSize == null?10:pageSize;  
    PageHelper.startPage(pageNo,pageSize);
    return BeanUtil.toPagedResult(mesWechatMapper.display(mesWechat));
	}

}
