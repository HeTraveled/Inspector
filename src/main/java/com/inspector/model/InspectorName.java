package com.inspector.model;

public class InspectorName {
    private Integer id;

    private Integer iid;

    private String responsibility;

    private String assistDept;

    private String charge;

    private String leadership;
    
    public InspectorName(){}

    public InspectorName(Integer iid, String responsibility, String assistDept,
			String charge, String leadership) {
		super();
		this.iid = iid;
		this.responsibility = responsibility;
		this.assistDept = assistDept;
		this.charge = charge;
		this.leadership = leadership;
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

    public String getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility == null ? null : responsibility.trim();
    }

    public String getAssistDept() {
        return assistDept;
    }

    public void setAssistDept(String assistDept) {
        this.assistDept = assistDept == null ? null : assistDept.trim();
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge == null ? null : charge.trim();
    }

    public String getLeadership() {
        return leadership;
    }

    public void setLeadership(String leadership) {
        this.leadership = leadership == null ? null : leadership.trim();
    }
}