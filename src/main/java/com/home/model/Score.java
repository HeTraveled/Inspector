package com.home.model;

public class Score {
    private Integer id;

    private Integer uid;

    private Integer source;

    private Integer sourceId;

    private Integer addSub;

    private Integer score;

    private Integer state;

    private Integer year;

    private Integer month;
    
    private String orderby;
    
    private Integer numflag;
    
    


	public Score(Integer uid, Integer sourceId) {
		super();
		this.uid = uid;
		this.sourceId = sourceId;
	}


	public Score(Integer uid, Integer source, Integer sourceId, Integer addSub,
			Integer score, Integer state, Integer month,Integer year) {
		super();
		this.uid = uid;
		this.source = source;
		this.sourceId = sourceId;
		this.addSub = addSub;
		this.score = score;
		this.state = state;
		this.year = year;
		this.month = month;
	}


	public Integer getNumflag() {
		return numflag;
	}


	public void setNumflag(Integer numflag) {
		this.numflag = numflag;
	}


	public String getOrderby() {
		return orderby;
	}


	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}


	public Score(){}


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
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

    public Integer getAddSub() {
        return addSub;
    }

    public void setAddSub(Integer addSub) {
        this.addSub = addSub;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }
}