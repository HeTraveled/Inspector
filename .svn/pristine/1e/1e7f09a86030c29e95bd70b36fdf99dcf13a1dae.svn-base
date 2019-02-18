package com.home.service.Impl;

import java.util.List;

import com.home.mapper.AnnouncementStateMapper;
import com.home.model.AnnouncementState;
import com.home.service.AnnouncementStateService;

public class AnnouncementStateImpl implements AnnouncementStateService {
	
	
		private AnnouncementStateMapper announcementStateMapper;

		public AnnouncementStateMapper getAnnouncementStateMapper() {
			return announcementStateMapper;
		}

		public void setAnnouncementStateMapper(AnnouncementStateMapper announcementStateMapper) {
			this.announcementStateMapper = announcementStateMapper;
		}

		@Override
		public Integer createList(List<AnnouncementState> announcementState) {
		
			return announcementStateMapper.createList(announcementState);
		}

		@Override
		public int deleteAnncState(int aid) {
			
			return announcementStateMapper.deleteByPrimaryKey(aid);
		}

		@Override
		public int updatestate(AnnouncementState announcementState) {
			
			return announcementStateMapper.updatestate(announcementState);
		}

		@Override
		public AnnouncementState select(int aid, int uid) {
			
			return announcementStateMapper.select(aid, uid);
		}

		@Override
		public List<AnnouncementState> selectall(int aid) {
			
			return announcementStateMapper.selectall(aid);
		}

		@Override
		public List<AnnouncementState> selectsize(int uid) {
			
			return announcementStateMapper.selectsize(uid);
		}

		@Override
		public List<AnnouncementState> selectanncsize(int aid) {
			
			return announcementStateMapper.selectanncsize(aid);
		}

		@Override
		public List<AnnouncementState> selectstatesize(int aid) {
		
			return announcementStateMapper.selectstatesize(aid);
		}

		@Override
		public Integer updatereadstate(AnnouncementState announcementState) {
		
			return announcementStateMapper.updatereadstate(announcementState);
		}

		}
