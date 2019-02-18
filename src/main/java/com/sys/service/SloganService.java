package com.sys.service;

import java.util.List;

import com.sys.model.Slogan;
import com.util.page.PagedResult;

public interface SloganService {

	Integer create(Slogan slogan);
	
	Integer update(Slogan slogan);
	
	Integer deletes(List<Integer> id);
	
	Integer first(Integer id);
	
	Integer updaterandom();
	
	Slogan random();
	
	Slogan selectid(Integer id);
	
	PagedResult<Slogan> display(Slogan slogan,Integer pageNo,Integer pageSize);
	
	Slogan randomNum();

}
