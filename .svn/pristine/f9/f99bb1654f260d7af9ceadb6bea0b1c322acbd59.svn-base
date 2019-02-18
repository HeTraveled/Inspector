package com.sys.service.impl;

import java.util.List;

import com.sys.mapper.MesWechatRecordMapper;
import com.sys.model.MesWechatRecord;
import com.sys.service.MesWechatRecordService;

public class MesWechatRecordImpl implements MesWechatRecordService {

	private MesWechatRecordMapper mesWechatRecordMapper;

	public MesWechatRecordMapper getMesWechatRecordMapper() {
		return mesWechatRecordMapper;
	}

	public void setMesWechatRecordMapper(MesWechatRecordMapper mesWechatRecordMapper) {
		this.mesWechatRecordMapper = mesWechatRecordMapper;
	}

	@Override
	public Integer deletes(List<Integer> mesId) {
		return mesWechatRecordMapper.deletes(mesId);
	}

	@Override
	public Integer creates(List<MesWechatRecord> mesWechatRecords) {
		return mesWechatRecordMapper.creates(mesWechatRecords);
	}

	@Override
	public List<MesWechatRecord> selectid(Integer id) {
		return mesWechatRecordMapper.selectid(id);
	}
	
	
}
