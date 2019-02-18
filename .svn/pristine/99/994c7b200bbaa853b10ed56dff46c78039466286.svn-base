package com.sys.service.impl;

import java.util.List;

import com.dept.model.Dept;
import com.github.pagehelper.PageHelper;
import com.sys.mapper.NewsMapper;
import com.sys.model.News;
import com.sys.service.NewsService;
import com.util.page.BeanUtil;
import com.util.page.PagedResult;

public class NewsImpl implements NewsService {
	
	private NewsMapper newsMapper;

	public NewsMapper getNewsMapper() {
		return newsMapper;
	}

	public void setNewsMapper(NewsMapper newsMapper) {
		this.newsMapper = newsMapper;
	}
	
	@Override
	public PagedResult<News> select(Integer pageNo,Integer pageSize) {
		
		pageNo = pageNo == null?1:pageNo;  
	    pageSize = pageSize == null?10:pageSize;  
    PageHelper.startPage(pageNo,pageSize);
    return BeanUtil.toPagedResult(newsMapper.select());
	}

	@Override
	public int creatnews(News news) {
		
		return newsMapper.insertSelective(news);
	}

	@Override
	public int delectnews(int id) {
		
		return newsMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<News> selectfive() {
		
		return newsMapper.selectfive();
	}
}
