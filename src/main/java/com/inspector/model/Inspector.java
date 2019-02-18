package com.inspector.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Inspector {
    private Integer iid;

    private String source;

    private Integer type;

    private Integer responsibility;

    private Integer leadership;

    private String body;

    private String requirements;

    private Integer frequency;

    private Date startTime;

    private Date endTime;

    private Date completeTime;

    private Date createTime;

    private String createBy;

    private String remarks;

    private String attachment;

    private Integer state;

    private String assistDept;
    
    private String cause;
    
    private Integer applyCause;
    
    private Integer delayDay;
    
    private String responsibilityname;
    
    private String orderby;
    
    private String leadershipname;
    
    private Integer did;
    
    private List<InspectorOpinion> opinion;
    
    private List<InspectorProgress> progress;
    
    private List<InspectorRecord> record;
    
    private List<InspectorMessage> message;
    
    private Integer nextDay;
    
    private String muchdept;
    
    private String[] files;
    
    private Integer display;
    
    
    
    public Integer getDisplay() {
		return display;
	}

	public void setDisplay(Integer display) {
		this.display = display;
	}

	public Inspector(Integer iid,Integer applyCause){
    	this.iid=iid;
    	this.applyCause=applyCause;
    }

    public Inspector(Integer iid,Date completeTime){
    	this.iid=iid;
    	this.completeTime=completeTime;
    }
    public Inspector(){}
    
    
    
    public String[] getFiles() {
		return files;
	}

	public void setFiles(String[] files) {
		this.files = files;
	}

	public Integer getIid() {
        return iid;
    }

    public String getMuchdept() {
		return muchdept;
	}

	public void setMuchdept(String muchdept) {
		this.muchdept = muchdept;
	}

	public void setIid(Integer iid) {
        this.iid = iid;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(Integer responsibility) {
        this.responsibility = responsibility;
    }


    public Integer getLeadership() {
		return leadership;
	}

	public void setLeadership(Integer leadership) {
		this.leadership = leadership;
	}

	public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body == null ? null : body.trim();
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements == null ? null : requirements.trim();
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment == null ? null : attachment.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getAssistDept() {
        return assistDept;
    }

    public void setAssistDept(String assistDept) {
        this.assistDept = assistDept == null ? null : assistDept.trim();
    }

	public String getResponsibilityname() {
		return responsibilityname;
	}

	public void setResponsibilityname(String responsibilityname) {
		this.responsibilityname = responsibilityname;
	}

	public String getOrderby() {
		return orderby;
	}

	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}

	public String getLeadershipname() {
		return leadershipname;
	}

	public void setLeadershipname(String leadershipname) {
		this.leadershipname = leadershipname;
	}
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public List<InspectorOpinion> getOpinion() {
		return opinion;
	}
	public void setOpinion(List<InspectorOpinion> opinion) {
		this.opinion = opinion;
	}
	public List<InspectorProgress> getProgress() {
		return progress;
	}
	public void setProgress(List<InspectorProgress> progress) {
		this.progress = progress;
	}
	public List<InspectorRecord> getRecord() {
		return record;
	}
	public void setRecord(List<InspectorRecord> record) {
		this.record = record;
	}
	public List<InspectorMessage> getMessage() {
		return message;
	}
	public void setMessage(List<InspectorMessage> message) {
		this.message = message;
	}
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
	public Integer getApplyCause() {
		return applyCause;
	}
	public void setApplyCause(Integer applyCause) {
		this.applyCause = applyCause;
	}
	public Integer getDelayDay() {
		return delayDay;
	}
	public void setDelayDay(Integer delayDay) {
		this.delayDay = delayDay;
	}

	public Integer getNextDay() {
		return nextDay;
	}

	public void setNextDay(Integer nextDay) {
		this.nextDay = nextDay;
	}


    
}