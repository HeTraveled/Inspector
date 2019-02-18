package com.home.mapper;


import java.util.List;


import org.apache.ibatis.annotations.Param;


import com.home.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    	
    User login(User user);
    
    List<User> select(@Param("name")String name,@Param("did")Integer did);

    Integer updatepwd(@Param("uid") String uid,@Param("password") String password);
    
    List<User> display(User user);
    
	Integer close(Integer uid);
	
	Integer start(Integer uid);
	
	Integer selectphoneSum(@Param("phone") String phone,@Param("employeeNo") String employeeNo);
	
	Integer selectridSum();
	
	List<User> headdid();
	
	Integer updatePrompt(Integer uid);
	
	List<User> selectdid(Integer did);
	
	Integer updateverifyNo(Integer[] uid);
	
	Integer updateverifyYes(Integer[] uid);
	
	List<User> selectusernumbers(@Param("did")Integer did);
	
	List<User> selectridins();
}
