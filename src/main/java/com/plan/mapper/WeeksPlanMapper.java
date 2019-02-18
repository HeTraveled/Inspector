package com.plan.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.home.model.User;
import com.plan.model.WeeksPlan;

public interface WeeksPlanMapper {
    int deleteByPrimaryKey(Integer wid);

    int insert(WeeksPlan record);

    int insertSelective(WeeksPlan record);

    WeeksPlan selectByPrimaryKey(@Param("wid")Integer wid);

    int updateByPrimaryKeySelective(WeeksPlan record);

    int updateByPrimaryKey(WeeksPlan record);
    
    List<WeeksPlan> selectall(@Param("years")Integer years,@Param("weeks")Integer weeks);
    
    WeeksPlan selectlastweek(@Param("uid")int uid,@Param("year")String year,@Param("lastweek")int lastweek);
    
    List<WeeksPlan> weeksplanauditleader(@Param("year")int year,@Param("month")int month,@Param("did")int did);
    
    User selectrole(@Param("uid")int uid);
    
    List<WeeksPlan> selectcommon(@Param("did")int did);
    
    WeeksPlan selectweekdept(@Param("did")int did ,@Param("years")int years,
    		@Param("weeks")int weeks);
    
    List<User> selectdeptsize(@Param("did")int did);
    
	List<WeeksPlan> selectEme(@Param("year") int year,@Param("month") int month,@Param("week") int week);
	
	List<WeeksPlan> selectlist();
	
	List<WeeksPlan> selectdeptcommon(@Param("years")Integer years,@Param("weeks")Integer weeks,@Param("did")Integer did);
	
	
}