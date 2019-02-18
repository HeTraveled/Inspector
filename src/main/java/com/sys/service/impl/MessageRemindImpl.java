package com.sys.service.impl;

import java.util.List;

import com.sys.mapper.MessageRemindMapper;
import com.sys.model.MessageRemind;
import com.sys.service.MessageRemindService;

public class MessageRemindImpl implements MessageRemindService {

	private MessageRemindMapper messageRemindMapper;

	public MessageRemindMapper getMessageRemindMapper() {
		return messageRemindMapper;
	}

	public void setMessageRemindMapper(MessageRemindMapper messageRemindMapper) {
		this.messageRemindMapper = messageRemindMapper;
	}

	@Override
	public Integer create(MessageRemind messageRemind) {
		return messageRemindMapper.insertSelective(messageRemind);
	}


	@Override
	public Integer update(MessageRemind messageRemind) {
		return messageRemindMapper.updateByPrimaryKeySelective(messageRemind);
	}

	@Override
	public Integer unreadNum(Integer uid) {
		return 	messageRemindMapper.unreadNum(uid);
	}

	@Override
	public MessageRemind selectid(Integer id,Integer uid) {
		return messageRemindMapper.selectid(id,uid);
	}

	@Override
	public List<MessageRemind> selectTop5(Integer uid) {
		return messageRemindMapper.selectTop5(uid);
	}

	@Override
	public Integer selectNum(Integer uid) {
		return messageRemindMapper.selectNum(uid);
	}

	@Override
	public Integer deletes(List<Integer> id) {
		return messageRemindMapper.deletes(id);
	}

	@Override
	public Integer empty(Integer uid) {
		return messageRemindMapper.empty(uid);
	}

	@Override
	public Integer batchflag(List<Integer> id) {
		return messageRemindMapper.batchflag(id);
	}

	@Override
	public Integer creates(List<MessageRemind> messageReminds) {
		return messageRemindMapper.creates(messageReminds);
	}
	
	
	
}
