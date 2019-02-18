package com.sys.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MesWechat {
    private Integer id;

    private String type;

    private String body;

    private Date time;

    private String reks;
    
    private String names;
    
    public MesWechat(){}
    
    

    public String getNames() {
		return names;
	}



	public void setNames(String names) {
		this.names = names;
	}



	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body == null ? null : body.trim();
    }
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getReks() {
        return reks;
    }

    public void setReks(String reks) {
        this.reks = reks == null ? null : reks.trim();
    }
}