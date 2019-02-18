package com.home.service.Impl;


import java.util.List;

import com.github.pagehelper.PageHelper;
import com.home.mapper.AnnouncementMapper;
import com.home.model.Announcement;
import com.home.service.AnnouncementServer;
import com.util.page.BeanUtil;
import com.util.page.PagedResult;

public class AnnouncementImpl implements AnnouncementServer {

	private AnnouncementMapper announcementMapper; 
	
	
	

	public AnnouncementMapper getAnnouncementMapper() {
		return announcementMapper;
	}



	public void setAnnouncementMapper(AnnouncementMapper announcementMapper) {
		this.announcementMapper = announcementMapper;
	}
	
	
	@Override
	public Integer save(Announcement announcement) {
		announcementMapper.insertSelective(announcement);
		return announcement.getId();
	}
	
	@Override
	public PagedResult<Announcement> select(Announcement announcement,Integer pageNo,Integer pageSize) {
		
		pageNo = pageNo == null?1:pageNo;  
	    pageSize = pageSize == null?10:pageSize;  
    PageHelper.startPage(pageNo,pageSize);
    return BeanUtil.toPagedResult(announcementMapper.select(announcement));
	}



	@Override
	public int deleteByPrimaryKey(int id) {
		
		return announcementMapper.deleteByPrimaryKey(id);
	}



	@Override
	public Announcement selectByPrimaryKey(Integer id) {
		
		return announcementMapper.selectByPrimaryKey(id);
	}



	@Override
	public int deleteAnnc(int id,int state,String invitation) {
		
		return announcementMapper.deleteAnnc(id,state,invitation);
	}



	@Override
	public int updateAnnc(Announcement announcement) {
		
		return announcementMapper.updateByPrimaryKeySelective(announcement);
	}



	@Override
	public List<Announcement> select2(Integer id) {
		// TODO Auto-generated method stub
		return announcementMapper.select2(id);
	}



	@Override
	public List<Announcement> select3() {
		// TODO Auto-generated method stub
		return announcementMapper.select3();
	}



	@Override
	public PagedResult<Announcement> selectaccomplish(Integer uid,Integer pageNo,Integer pageSize) {
		
		pageNo = pageNo == null?1:pageNo;  
	    pageSize = pageSize == null?10:pageSize;  
    PageHelper.startPage(pageNo,pageSize);
    return BeanUtil.toPagedResult(announcementMapper.selectaccomplish(uid));
	}



	

	
}
