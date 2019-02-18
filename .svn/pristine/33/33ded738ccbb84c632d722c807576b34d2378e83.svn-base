package com.inspector.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class InspectorOpinion {
    private Integer id;

    private Integer iid;

    private String description;

    private String createBy;

    private Date createTime;
    
    public InspectorOpinion(){}
    
    

    public InspectorOpinion(Integer iid, String description, String createBy,
			Date createTime) {
		super();
		this.iid = iid;
		this.description = description;
		this.createBy = createBy;
		this.createTime = createTime;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}