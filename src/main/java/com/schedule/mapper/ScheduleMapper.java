package com.schedule.mapper;

import java.util.List;

import com.schedule.model.Schedule;

public interface ScheduleMapper {
    int deleteByPrimaryKey(Integer sid);
   

    int insert(Schedule record);

    int insertSelective(Schedule record);

    Schedule selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(Schedule record);

    int updateByPrimaryKey(Schedule record);
    
	List<Schedule> selectMonth(Integer uid);
	
	List<Schedule> selectday();
	
	List<Schedule> selectaid(Integer aid);
	
	Integer deleteall(List<Schedule> schedules);
	
	Integer creatschedule(List<Schedule> schedule) ;
}