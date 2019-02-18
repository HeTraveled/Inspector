package com.home.service;

import java.util.List;

import com.home.model.AnnouncementState;



public interface AnnouncementStateService {

	
	Integer createList(List<AnnouncementState> announcementState);
	
	int deleteAnncState(int aid);
	
	int updatestate(AnnouncementState announcementState);
	
	AnnouncementState select(int aid,int uid);
	
	List<AnnouncementState> selectall(int aid);
	
	List<AnnouncementState> selectsize(int uid);
	
	List<AnnouncementState> selectanncsize(int aid);
	
	List<AnnouncementState> selectstatesize(int aid);
	
	Integer updatereadstate(AnnouncementState announcementState); 
}
