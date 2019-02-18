package com.sys.model;

import java.util.Date;

public class MessageRemind {
    private Integer id;

    private Integer mid;

    private Integer uid;

    private Integer state;

    private Date readingTime;
    
    private Messages messages;
    
    public MessageRemind(){}
    
    

    public Messages getMessages() {
		return messages;
	}



	public void setMessages(Messages messages) {
		this.messages = messages;
	}



	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getReadingTime() {
        return readingTime;
    }

    public void setReadingTime(Date readingTime) {
        this.readingTime = readingTime;
    }
}