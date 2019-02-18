package com.home.service;

import java.util.List;

import com.home.model.Score;
import com.util.page.PagedResult;

public interface ScoreService {

	Integer create(Score score);
	
	Integer update(Score score);
	
	Integer delete(Integer id);

	PagedResult<Score> display(Score score,Integer pageNo,Integer pageSize);
	
	List<Score> selectMonth(Integer uid,Integer year,Integer month);
	
	Integer monthscore(Integer uid,Integer year,Integer month,Integer addSub);
	
	Score selectid(Integer id);
	
	Integer creates(List<Score> scores);
	
	Integer lose(Score score);
}
