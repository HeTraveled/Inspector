package com.dept.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dept.model.Dept;
import com.home.model.User;

public interface DeptMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);
    
    boolean deptsave(Dept dept);
    
    Dept FindByDeptName(String departmentname );
    
    Dept selectdept(String departmentname);
    
    List<Dept> selectall();
    List<Dept> all();
    
    Dept selectByPrimaryKey(int id);
    
    List<Dept> selectname(@Param("departmentname") String departmentname);
    
    List<Dept> selectscoreName(@Param("departmentname") String departmentname);
    
	List<Dept> display();
	
	List<Dept> selecttopid(Integer id);
	
	List<User> selectdid(Integer id);
	
	List<Dept> selecttopDid(Integer id);
	
	String selectSupervisor(Integer id);
	
	User selectLeadership(Integer id);
	
	 List<Dept> select(@Param("did") int did);
	 
		int countPri(@Param("uid") Integer uid);

		int countLead(@Param("uid") Integer uid);
		
		List<Dept> principal(Integer principal);
	
}