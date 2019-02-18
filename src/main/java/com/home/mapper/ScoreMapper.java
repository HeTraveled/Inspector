package com.home.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.home.model.Score;

public interface ScoreMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Score record);

    int insertSelective(Score record);

    Score selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Score record);

    int updateByPrimaryKey(Score record);
    
    List<Score> display(Score score);
    
	List<Score> selectMonth(@Param("uid") Integer uid,@Param("year") Integer year,@Param("month") Integer month);
	
	Integer monthscore(@Param("uid") Integer uid,@Param("year") Integer year,@Param("month") Integer month,@Param("addSub") Integer addSub);
	
	Integer creates(List<Score> scores);
	
	Integer lose(Score score);
}