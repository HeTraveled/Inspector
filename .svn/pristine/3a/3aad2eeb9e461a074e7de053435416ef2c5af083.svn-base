package com.home.service;

import java.util.List;

import com.home.model.User;
import com.util.page.PagedResult;

public interface UserService {

	User login(User user);
	
	User selectuid(Integer uid);
	
	Integer update(User user);

	PagedResult<User> select(String name,Integer pageNo,Integer pageSize,Integer did);
	
	Integer updatepwd(String uid,String password);
	
	PagedResult<User> display(User user,Integer pageNo,Integer pageSize);
	
	Integer close(Integer uid);
	
	Integer start(Integer uid);

	Integer delete(Integer uid);
	
	Integer create(User user);
	
	Integer selectphoneSum(String phone,String employeeNo);
	
	Integer selectridSum();
	
	List<User> headdid();
	
	Integer updatePrompt(Integer uid);
	
	List<User> selectdid(Integer did);
	
	Integer updateverifyNo(Integer[] uid);
	
	Integer updateverifyYes(Integer[] uid);
	
	PagedResult<User> selectscore(Integer did,Integer pageNo,Integer pageSize);
	
	List<User> selectusernumbers(Integer did);
	
	List<User> selectridins();
}
