package com.official.service.impl;

import com.github.pagehelper.PageHelper;
import com.official.mapper.OfficialArticleMapper;
import com.official.model.OfficialArticle;
import com.official.service.OfficialArticleService;
import com.util.page.BeanUtil;
import com.util.page.PagedResult;

public class OfficialArticleImpl implements OfficialArticleService {

	private OfficialArticleMapper officialArticleMapper;

	public OfficialArticleMapper getOfficialArticleMapper() {
		return officialArticleMapper;
	}

	public void setOfficialArticleMapper(OfficialArticleMapper officialArticleMapper) {
		this.officialArticleMapper = officialArticleMapper;
	}

	@Override
	public Integer create(OfficialArticle officialArticle) {
		return officialArticleMapper.insertSelective(officialArticle);
	}

	@Override
	public Integer update(OfficialArticle officialArticle) {
		return officialArticleMapper.updateByPrimaryKeySelective(officialArticle);
	}

	@Override
	public Integer delete(Integer id) {
		return officialArticleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public PagedResult<OfficialArticle> display(
			OfficialArticle officialArticle, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null?1:pageNo;  
	    pageSize = pageSize == null?10:pageSize;  
    PageHelper.startPage(pageNo,pageSize);
    return BeanUtil.toPagedResult(officialArticleMapper.display(officialArticle));
	}

	@Override
	public OfficialArticle selectid(Integer id) {
		return officialArticleMapper.selectByPrimaryKey(id);
	}
	
	
}
