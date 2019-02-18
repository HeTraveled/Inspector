package com.schedule.model;

import java.util.List;

public class ScheduleRemind {
    private Integer id;

    private Integer sid;

    private Integer uid;
    
    private List<Schedule> schedule;
    
    private String wechat;
    
    public ScheduleRemind(){}
    
    

    public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public ScheduleRemind(Integer sid, Integer uid) {
		super();
		this.sid = sid;
		this.uid = uid;
	}

	public List<Schedule> getSchedule() {
		return schedule;
	}

	public void setSchedule(List<Schedule> schedule) {
		this.schedule = schedule;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}