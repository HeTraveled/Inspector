package com.sys.service;

import com.sys.model.Messages;
import com.util.page.PagedResult;

public interface MessagesService {

	PagedResult<Messages> display(Messages messages,Integer pageNo,Integer pageSize);
	
	Integer create(Messages messages);
	
	Integer MonthPlancreate(Messages messages);
}
