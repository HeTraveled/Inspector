package com.inspector.service;

import java.util.List;

import com.inspector.model.InspectorMessage;
import com.util.page.PagedResult;

public interface InspectorMessageService {
	
	Integer create(InspectorMessage inspectorMessage);
	
	PagedResult<InspectorMessage> selectiid(Integer iid,Integer pageNo,Integer pageSize);
	
	List<InspectorMessage> selecttop3(Integer iid);

	Integer delete(Integer iid);
}
