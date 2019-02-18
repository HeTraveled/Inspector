package com.sys.service;

import java.util.List;

import com.sys.model.Horn;
import com.util.page.PagedResult;

public interface HornService {

	Integer create(Horn horn);
	
	Integer update(Horn horn);
	
	Integer delete(Integer id);
	
	PagedResult<Horn> display(Horn horn,Integer pageNo,Integer pageSize);
	
	Horn selectid(Integer id);
	
	List<Horn> select24H();
	
	Integer deletes(List<Integer> id);
}
