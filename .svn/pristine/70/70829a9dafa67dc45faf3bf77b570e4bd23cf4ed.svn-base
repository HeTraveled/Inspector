package com.home.service.Impl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.home.mapper.ScoreMapper;
import com.home.model.Score;
import com.home.service.ScoreService;
import com.util.page.BeanUtil;
import com.util.page.PagedResult;

public class ScoreImpl implements ScoreService {

	private ScoreMapper scoreMapper;

	public ScoreMapper getScoreMapper() {
		return scoreMapper;
	}

	public void setScoreMapper(ScoreMapper scoreMapper) {
		this.scoreMapper = scoreMapper;
	}

	@Override
	public Integer create(Score score) {
		return scoreMapper.insertSelective(score);
	}

	@Override
	public Integer update(Score score) {
		return scoreMapper.updateByPrimaryKeySelective(score);
	}

	@Override
	public Integer delete(Integer id) {
		return scoreMapper.deleteByPrimaryKey(id);
	}

	@Override
	public PagedResult<Score> display(Score score, Integer pageNo,
			Integer pageSize) {
		pageNo = pageNo == null?1:pageNo;  
	    pageSize = pageSize == null?20:pageSize;  
    PageHelper.startPage(pageNo,pageSize);
    return BeanUtil.toPagedResult(scoreMapper.display(score));
	}

	@Override
	public List<Score> selectMonth(Integer uid,Integer year,Integer month) {
		return scoreMapper.selectMonth(uid,year,month);
	}

	@Override
	public Integer monthscore(Integer uid, Integer year, Integer month,Integer addSub) {
		Integer socre=scoreMapper.monthscore(uid, year, month,addSub);
		if(socre==null)return 0;
		else return socre;
	}

	@Override
	public Score selectid(Integer id) {
		return scoreMapper.selectByPrimaryKey(id);
	}

	@Override
	public Integer creates(List<Score> scores) {
		return scoreMapper.creates(scores);
	}

	@Override
	public Integer lose(Score score) {
		return scoreMapper.lose(score);
	}
	
	
}
