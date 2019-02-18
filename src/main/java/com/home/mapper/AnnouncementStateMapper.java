package com.home.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.home.model.AnnouncementState;

public interface AnnouncementStateMapper {
    int deleteByPrimaryKey(Integer aid);

    int insert(AnnouncementState record);

    int insertSelective(AnnouncementState record);

    AnnouncementState selectByPrimaryKey(Integer aid);

    int updateByPrimaryKeySelective(AnnouncementState record);

    int updateByPrimaryKey(AnnouncementState record);
    
    Integer createList(List<AnnouncementState> announcementState);
    
    int updatestate(AnnouncementState announcementState);
    
    AnnouncementState select(@Param("aid")int aid,@Param("uid")int uid);
    List<AnnouncementState> selectall(@Param("aid")int aid);
    
    List<AnnouncementState> selectsize(int uid);
    
    List<AnnouncementState> selectanncsize(int aid);
	
	List<AnnouncementState> selectstatesize(int aid);
	
	Integer updatereadstate(AnnouncementState announcementState); 
}