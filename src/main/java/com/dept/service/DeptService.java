package com.dept.service;

import java.util.List;

import com.dept.model.Dept;
import com.home.model.User;

import com.util.page.PagedResult;

public interface DeptService {

	Integer deptsave(Dept dept);
	
	Dept selectdept(String departmentname);
	
	List<Dept> selectall();
	
	int deleteByPrimaryKey(int id);
	
	Dept selectByPrimaryKey(int id);
	
	int updateByPrimaryKey(Dept  record);
	
	PagedResult<Dept> selectname(String departmentname,Integer pageNo,Integer pageSize);
	
	PagedResult<Dept> selectscoreName(String departmentname,Integer pageNo,Integer pageSize);
	
	List<Dept> display();
	
	List<Dept> selecttopid(Integer id);
	
	List<User> selectdid(Integer id);
	
	List<Dept> selecttopDid(Integer id);
	
	String selectSupervisor(Integer id);
	
	List<Dept>selectname(String departmentname);
	
	User selectLeadership(Integer id);
	
	PagedResult<Dept> select(int did,Integer pageNo,Integer pageSize);
	
	List<Dept> all();

	int countPri(Integer uid);

	int countLead(Integer uid);
	
	List<Dept> principal(Integer principal);
}
