package com.sys.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Regulations {
    private Integer id;

    private Integer type;
    
    private String title;

    private String attachment;

    private String remarks;

    private Integer state;

    private String createBy;

    private Date createTime;
    
    private String[] files;
    
    public Regulations(){}
    
    
    
    public String[] getFiles() {
		return files;
	}



	public void setFiles(String[] files) {
		this.files = files;
	}



	public Regulations(Integer state){
    	this.state=state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment == null ? null : attachment.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
    
}