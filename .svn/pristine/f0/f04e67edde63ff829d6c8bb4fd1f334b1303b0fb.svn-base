package com.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.sys.mapper.MessagesMapper;
import com.sys.model.Messages;
import com.sys.service.MessagesService;
import com.util.page.BeanUtil;
import com.util.page.PagedResult;

public class MessagesImpl implements MessagesService {

	private MessagesMapper messagesMapper;

	public MessagesMapper getMessagesMapper() {
		return messagesMapper;
	}

	public void setMessagesMapper(MessagesMapper messagesMapper) {
		this.messagesMapper = messagesMapper;
	}

	@Override
	public PagedResult<Messages> display(Messages messages, Integer pageNo,
			Integer pageSize) {
		pageNo = pageNo == null?1:pageNo;  
	    pageSize = pageSize == null?10:pageSize;  
    PageHelper.startPage(pageNo,pageSize);
    return BeanUtil.toPagedResult(messagesMapper.display(messages));
	}

	@Override
	public Integer create(Messages messages) {

		
		messagesMapper.insertSelective(messages);
		return messages.getId();
	}
	@Override
	public Integer MonthPlancreate(Messages messages) {
		messages.setType(2);

		messagesMapper.insertSelective(messages);
		return messages.getId();
	}
}
