package com.home.model;

import java.util.List;

public class Menu {
    private Integer mid;

    private String name;

    private Integer topMid;

    private String url;
    
    private String icon;
    
    private List<Menu> menu;
    
    
    public Menu(){}

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getTopMid() {
        return topMid;
    }

    public void setTopMid(Integer topMid) {
        this.topMid = topMid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

	public List<Menu> getMenu() {
		return menu;
	}

	public void setMenu(List<Menu> menu) {
		this.menu = menu;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
}