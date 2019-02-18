package com.sys.service;

import java.util.List;

import com.sys.model.MesWechatRecord;

public interface MesWechatRecordService {

	Integer deletes(List<Integer> mesId);
	
	Integer creates(List<MesWechatRecord> mesWechatRecords);
	
	List<MesWechatRecord> selectid(Integer id);
}
