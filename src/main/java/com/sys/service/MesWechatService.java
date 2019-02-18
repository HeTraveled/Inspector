package com.sys.service;

import java.util.List;

import com.sys.model.MesWechat;
import com.util.page.PagedResult;

public interface MesWechatService {

	Integer deletes(List<Integer> id);
	
	Integer create(MesWechat mesWechat);
	
	MesWechat selectid(Integer id);
	
	PagedResult<MesWechat> display(MesWechat mesWechat,Integer pageNo,Integer pageSize);
}
