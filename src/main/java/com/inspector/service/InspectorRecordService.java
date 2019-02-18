package com.inspector.service;

import com.inspector.model.InspectorRecord;
import com.util.page.PagedResult;

public interface InspectorRecordService {

	PagedResult<InspectorRecord> selectiid(Integer iid,Integer pageNo,Integer pageSize);
	
	Integer delete(Integer iid);
}
