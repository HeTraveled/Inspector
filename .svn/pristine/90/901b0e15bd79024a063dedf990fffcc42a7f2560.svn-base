package com.home.service.Impl;

import java.util.List;

import com.home.mapper.MenuMapper;
import com.home.model.Menu;
import com.home.service.MenuService;

public class MenuImpl implements MenuService {

	private MenuMapper menuMapper;

	public MenuMapper getMenuMapper() {
		return menuMapper;
	}

	public void setMenuMapper(MenuMapper menuMapper) {
		this.menuMapper = menuMapper;
	}

	@Override
	public List<Menu> selectall() {
		return menuMapper.selectall();
	}
}
