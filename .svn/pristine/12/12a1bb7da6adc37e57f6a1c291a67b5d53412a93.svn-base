package com.schedule.service.impl;

import java.util.List;

import com.schedule.mapper.ScheduleMapper;
import com.schedule.model.Schedule;
import com.schedule.service.ScheduleService;

public class ScheduleImpl implements ScheduleService {

	private ScheduleMapper scheduleMapper;

	public ScheduleMapper getScheduleMapper() {
		return scheduleMapper;
	}

	public void setScheduleMapper(ScheduleMapper scheduleMapper) {
		this.scheduleMapper = scheduleMapper;
	}

	@Override
	public Integer create(Schedule schedule) {
		scheduleMapper.insertSelective(schedule);
		return schedule.getSid();
	}

	@Override
	public List<Schedule> selectMonth(Integer uid) {
		return scheduleMapper.selectMonth(uid);
	}

	@Override
	public List<Schedule> selectday() {
		return scheduleMapper.selectday();
	}

	@Override
	public Schedule selectid(Integer sid) {
		return scheduleMapper.selectByPrimaryKey(sid);
	}

	@Override
	public Integer update(Schedule schedule) {
		return scheduleMapper.updateByPrimaryKeySelective(schedule);
	}

	@Override
	public Integer delete(Integer sid) {
		return scheduleMapper.deleteByPrimaryKey(sid);
	}

	@Override
	public List<Schedule> selectaid(Integer aid) {
		return scheduleMapper.selectaid(aid);
	}

	@Override
	public Integer deleteall(List<Schedule> schedules) {
		return scheduleMapper.deleteall(schedules);
	}

	@Override
	public Integer creatlist(List<Schedule> schedule) {
		
		return scheduleMapper.creatschedule(schedule);
	}

}
