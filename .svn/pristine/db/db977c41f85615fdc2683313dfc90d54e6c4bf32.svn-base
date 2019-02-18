package com.home.service.Impl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.home.mapper.UserMapper;
import com.home.model.User;
import com.home.service.UserService;
import com.util.page.BeanUtil;
import com.util.page.PagedResult;

public class UserImpl implements UserService {

	private UserMapper userMapper;

	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public User login(User user) {
		
		return userMapper.login(user);
	}

	@Override
	public User selectuid(Integer uid) {
		return userMapper.selectByPrimaryKey(uid);
	}

	@Override
	public Integer update(User user) {
		return userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public Integer updatepwd(String uid, String password) {
		return userMapper.updatepwd(uid, password);
	}

	@Override
	public PagedResult<User> display(User user, Integer pageNo,
			Integer pageSize) {
		pageNo = pageNo == null?1:pageNo;  
	    pageSize = pageSize == null?20:pageSize;  
    PageHelper.startPage(pageNo,pageSize);
    return BeanUtil.toPagedResult(userMapper.display(user));
	}
	
	@Override
	public PagedResult<User> select(String name,Integer pageNo,Integer pageSize,Integer did) {
		
		pageNo = pageNo == null?1:pageNo;  
	    pageSize = pageSize == null?10:pageSize;  
    PageHelper.startPage(pageNo,pageSize);
    return BeanUtil.toPagedResult(userMapper.select(name,did));
	}

	@Override
	public Integer close(Integer uid) {
		return userMapper.close(uid);
	}

	@Override
	public Integer start(Integer uid) {
		return userMapper.start(uid);
	}

	@Override
	public Integer delete(Integer uid) {
		return userMapper.deleteByPrimaryKey(uid);
	}

	@Override
	public Integer create(User user) {
		return userMapper.insertSelective(user);
	}

	@Override
	public Integer selectphoneSum(String phone,String employeeNo) {
		return userMapper.selectphoneSum(phone,employeeNo);
	}

	@Override
	public Integer selectridSum() {
		return userMapper.selectridSum();
	}

	@Override
	public List<User> headdid() {
		return userMapper.headdid();
	}

	@Override
	public Integer updatePrompt(Integer uid) {
		return userMapper.updatePrompt(uid);
	}

	@Override
	public List<User> selectdid(Integer did) {
		return userMapper.selectdid(did);
	}


	@Override
	public PagedResult<User> selectscore(Integer did, Integer pageNo,
			Integer pageSize) {
		pageNo = pageNo == null?1:pageNo;  
	    pageSize = pageSize == null?20:pageSize;  
    PageHelper.startPage(pageNo,pageSize);
    return BeanUtil.toPagedResult(userMapper.selectdid(did));
	}

	@Override
	public List<User> selectusernumbers(Integer did) {
	
		return userMapper.selectusernumbers(did);
	}
@Override
public Integer updateverifyNo(Integer[] uid) {
	return userMapper.updateverifyNo(uid);
}
@Override
public Integer updateverifyYes(Integer[] uid) {
	return userMapper.updateverifyYes(uid);
}

@Override
public List<User> selectridins() {
	return userMapper.selectridins();
}

}
