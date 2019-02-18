package com.inspector.model;

import java.util.List;

public class AssistDeptTree {

	private Integer id;
	
	private String text;
	
	private List<AssistDeptTree> children;
	
	private List<AssistDeptTree> user;

	
	
	public List<AssistDeptTree> getUser() {
		return user;
	}

	public void setUser(List<AssistDeptTree> user) {
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<AssistDeptTree> getChildren() {
		return children;
	}

	public void setChildren(List<AssistDeptTree> children) {
		this.children = children;
	}
	
	
}
