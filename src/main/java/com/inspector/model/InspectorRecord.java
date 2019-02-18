package com.inspector.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class InspectorRecord {
    private Integer id;

    private Integer iid;

    private Date updateTime;

    private String updateBy;

    private String updateBody;
    
    public InspectorRecord(){}

    public InspectorRecord(Integer iid, Date updateTime, String updateBy,
			String updateBody) {
		super();
		this.iid = iid;
		this.updateTime = updateTime;
		this.updateBy = updateBy;
		this.updateBody = updateBody;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public String getUpdateBody() {
        return updateBody;
    }

    public void setUpdateBody(String updateBody) {
        this.updateBody = updateBody == null ? null : updateBody.trim();
    }
}