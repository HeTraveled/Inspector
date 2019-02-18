package com.plan.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.plan.model.WeeksPlanNext;

public interface WeeksPlanNextMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WeeksPlanNext record);

    int insertSelective(WeeksPlanNext record);

    WeeksPlanNext selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WeeksPlanNext weeksplannext);

    int updateByPrimaryKey(WeeksPlanNext record);
    
    List<WeeksPlanNext> selectbynext(@Param("wid") int wid);
    
    List<WeeksPlanNext> selectbythisweek(Date lastweekmonday,Date lastweeksunday);
    
    Integer weeksplannextinsert(List<WeeksPlanNext> weeksplannext);
    
    List<WeeksPlanNext> weeksplannextoverdue();
    
    Integer updateOverdue(List<Integer> id);
    
    List<WeeksPlanNext> selectEme(@Param("wid") Integer wid);
    
    List<Object> weeksEmergencyTop5(@Param("did") Integer did,@Param("emergency") Integer emergency);
    
    List<Object> weeksEmergency(@Param("did") Integer did,@Param("emergency") Integer emergency);
   
}