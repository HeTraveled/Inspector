package com.plan.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class WeeksPlanMessage {
    private Integer id;

    private Integer wid;

    private String message;

    private String createBy;

    private Date createTime;
    
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}