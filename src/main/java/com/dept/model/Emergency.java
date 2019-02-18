package com.dept.model;

public class Emergency {
    private Integer id;

    private Integer did;

    private Integer emergency;

    private Integer source;

    private Integer sourceId;
    
    private String muchdept;
    
    
    
    public Emergency(Integer did, Integer emergency, String muchdept) {
		super();
		this.did = did;
		this.emergency = emergency;
		this.muchdept = muchdept;
	}



	public String getMuchdept() {
		return muchdept;
	}



	public void setMuchdept(String muchdept) {
		this.muchdept = muchdept;
	}



	public Emergency(){}
    
    

    public Emergency(Integer did, Integer source, Integer sourceId) {
		super();
		this.did = did;
		this.source = source;
		this.sourceId = sourceId;
	}



	public Emergency(Integer did, Integer emergency, Integer source,
			Integer sourceId) {
		super();
		this.did = did;
		this.emergency = emergency;
		this.source = source;
		this.sourceId = sourceId;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Integer getEmergency() {
        return emergency;
    }

    public void setEmergency(Integer emergency) {
        this.emergency = emergency;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }
}