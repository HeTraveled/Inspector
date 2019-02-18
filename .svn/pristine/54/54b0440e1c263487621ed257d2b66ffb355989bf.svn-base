package com.sys.service;

import java.util.List;

import com.sys.model.MessageRemind;

public interface MessageRemindService {

	Integer create(MessageRemind messageRemind);
	
	Integer update(MessageRemind messageRemind);
	
	Integer unreadNum(Integer uid);
	
	MessageRemind selectid(Integer id,Integer uid);
	
	List<MessageRemind> selectTop5(Integer uid);
	
	Integer selectNum(Integer uid);
	
	Integer deletes(List<Integer> id);
	
	Integer empty(Integer uid);
	
	Integer batchflag(List<Integer> id);
	
	Integer creates(List<MessageRemind> messageReminds);
}
