package com.sys.service.impl;

import java.util.List;

import com.sys.mapper.AttachmentsMapper;
import com.sys.model.Attachments;
import com.sys.service.AttachmentsService;

public class AttachmentsImpl implements AttachmentsService {

	private AttachmentsMapper attachmentsMapper;

	public AttachmentsMapper getAttachmentsMapper() {
		return attachmentsMapper;
	}

	public void setAttachmentsMapper(AttachmentsMapper attachmentsMapper) {
		this.attachmentsMapper = attachmentsMapper;
	}

	@Override
	public Integer creates(List<Attachments> attachments) {
		return attachmentsMapper.creates(attachments);
	}

	@Override
	public Integer create(Attachments attachments) {
		return attachmentsMapper.insertSelective(attachments);
	}

	@Override
	public Integer delete(Integer id) {
		return attachmentsMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Attachments> display(Attachments attachments) {
		return attachmentsMapper.display(attachments);
	}

	@Override
	public Attachments selectid(Integer id) {
		return attachmentsMapper.selectByPrimaryKey(id);
	}

	@Override
	public Integer delete(Attachments attachments) {
		return attachmentsMapper.delete(attachments);
	}

}
