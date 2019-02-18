package com.dept.service.Impl;

import java.util.List;

import com.dept.mapper.DeptMapper;
import com.dept.model.Dept;
import com.dept.service.DeptService;
import com.github.pagehelper.PageHelper;
import com.home.model.User;

import com.util.page.BeanUtil;
import com.util.page.PagedResult;

public class DeptImpl implements DeptService {

	
	private DeptMapper deptMapper; 
	
	
	public DeptMapper getDeptMapper() {
		return deptMapper;
	}

	public void setDeptMapper(DeptMapper deptMapper) {
		this.deptMapper = deptMapper;
	}

	@Override
	public Dept selectdept(String departmentname) {
		
		return deptMapper.selectdept(departmentname);
	}

	@Override
	public Integer deptsave(Dept dept) {
	
		return deptMapper.insertSelective(dept);
	}

	@Override
	public List<Dept> selectall() {
	
		return deptMapper.selectall();
	}

	@Override
	public int deleteByPrimaryKey(int id) {
		
		return deptMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Dept selectByPrimaryKey(int  id) {
		
		return deptMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(Dept record) {
		
		return deptMapper.updateByPrimaryKey(record);
	}

	@Override
	public PagedResult<Dept> selectname(String departmentname,Integer pageNo,Integer pageSize) {
		
		pageNo = pageNo == null?1:pageNo;  
	    pageSize = pageSize == null?10:pageSize;  
    PageHelper.startPage(pageNo,pageSize);
    return BeanUtil.toPagedResult(deptMapper.selectname(departmentname));
	}

	@Override
	public List<Dept> display() {
		return deptMapper.display();
	}

	@Override
	public List<Dept> selecttopid(Integer id) {
		return deptMapper.selecttopid(id);
	}

	@Override
	public List<User> selectdid(Integer id){
		return deptMapper.selectdid(id);
	}

	@Override
	public List<Dept> selecttopDid(Integer id) {
	
		return deptMapper.selecttopDid(id);
	}

	@Override
	public String selectSupervisor(Integer id) {
		return deptMapper.selectSupervisor(id);
	}

	@Override
	public List<Dept> selectname(String departmentname) {
		return deptMapper.selectname(departmentname);
	}

	@Override
	public User selectLeadership(Integer id) {
		return deptMapper.selectLeadership(id);
	}
	@Override
	public PagedResult<Dept> select(int did,Integer pageNo,Integer pageSize) {
		
		pageNo = pageNo == null?1:pageNo;  
	    pageSize = pageSize == null?10:pageSize;  
    PageHelper.startPage(pageNo,pageSize);
    return BeanUtil.toPagedResult(deptMapper.select(did));
	}


	@Override
	public List<Dept> all() {
		
		 return deptMapper.all();
	}


	@Override
	public int countPri(Integer uid) {
		return deptMapper.countPri(uid);
	}

	@Override
	public int countLead(Integer uid) {
		return deptMapper.countLead(uid);
	}

	@Override
	public List<Dept> principal(Integer principal) {
		return deptMapper.principal(principal);
	}

	@Override
	public PagedResult<Dept> selectscoreName(String departmentname,
			Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null?1:pageNo;  
	    pageSize = pageSize == null?10:pageSize;  
    PageHelper.startPage(pageNo,pageSize);
    return BeanUtil.toPagedResult(deptMapper.selectscoreName(departmentname));
	}

}


