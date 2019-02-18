package com.wechat.service;

import com.wechat.model.Token;

public interface TokenService {

	Token display();
	
	Integer update(String token);
}
