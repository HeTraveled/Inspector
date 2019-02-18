package com.schedule.service;

import java.util.List;

import com.schedule.model.Schedule;

public interface ScheduleService {

	Integer create(Schedule schedule);
	
	Integer creatlist(List<Schedule> schedule);
	
	List<Schedule> selectMonth(Integer uid);
	
	List<Schedule> selectday();
	
	Schedule selectid(Integer sid);
	
	Integer update(Schedule schedule);
	
	Integer delete(Integer sid);
	
	List<Schedule> selectaid(Integer aid);
	
	Integer deleteall(List<Schedule> schedules);
}
