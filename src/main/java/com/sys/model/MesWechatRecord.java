package com.sys.model;

public class MesWechatRecord {
    private Integer id;

    private Integer mesId;

    private Integer uid;
    
    private String name;
    
    
    
    public MesWechatRecord(Integer mesId, Integer uid) {
		super();
		this.mesId = mesId;
		this.uid = uid;
	}



	public MesWechatRecord(){}

    
    
    public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMesId() {
        return mesId;
    }

    public void setMesId(Integer mesId) {
        this.mesId = mesId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}