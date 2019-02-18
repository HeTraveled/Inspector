package com.dept.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class EmergencyRecord {
    private Integer id;

    private String body;

    private Integer state;

    private Date endTime;
    
    private Integer emergency;
    
    private Integer did;
    
    private String liable;
    
    
    
    
    public String getLiable() {
		return liable;
	}

	public void setLiable(String liable) {
		this.liable = liable;
	}

	public Integer getDid() {
		return did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public EmergencyRecord(){}

    public Integer getEmergency() {
		return emergency;
	}

	public void setEmergency(Integer emergency) {
		this.emergency = emergency;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body == null ? null : body.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}


}