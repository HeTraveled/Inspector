package com.sys.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Messages {
    private Integer id;

    private String title;

    private String body;

    private Integer url;

    private Integer type;

    private Date createTime;
    
    private Integer state;
    
    private Integer uid;
    
    private String orderBy;
    
    private Integer mrId;
    
    
    
    
    
    public Messages(String title,  Integer type) {
		super();
		this.title = title;
		this.type = type;
	}
    public Messages(String title,  Integer type,Integer url) {
		super();
		this.title = title;
		this.type = type;
		this.url=url;
	}


	public Integer getMrId() {
		return mrId;
	}



	public void setMrId(Integer mrId) {
		this.mrId = mrId;
	}



	public String getOrderBy() {
		return orderBy;
	}



	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}



	public Integer getUid() {
		return uid;
	}



	public void setUid(Integer uid) {
		this.uid = uid;
	}



	public Messages(){}
    
    

    public Integer getState() {
		return state;
	}



	public void setState(Integer state) {
		this.state = state;
	}



	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body == null ? null : body.trim();
    }



    public Integer getUrl() {
		return url;
	}



	public void setUrl(Integer url) {
		this.url = url;
	}



	public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }


    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public Date getCreateTime() {
		return createTime;
	}



	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}



}