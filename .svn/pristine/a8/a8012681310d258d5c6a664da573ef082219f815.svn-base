package com.wechat.service.impl;

import com.wechat.mapper.TokenMapper;
import com.wechat.model.Token;
import com.wechat.service.TokenService;

public class TokenImpl implements TokenService {

	private TokenMapper tokenMapper;
	
	
	public TokenMapper getTokenMapper() {
		return tokenMapper;
	}

	public void setTokenMapper(TokenMapper tokenMapper) {
		this.tokenMapper = tokenMapper;
	}

	@Override
	public Token display() {
		return tokenMapper.display();
	}

	@Override
	public Integer update(String token) {
		return tokenMapper.update(token);
	}

}
