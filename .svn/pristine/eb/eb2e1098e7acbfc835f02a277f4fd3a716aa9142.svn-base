package com.plan.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MonthPlan {
    private Integer mid;

    private Integer uid;

    private String conclusion;

    private String remarks;

    private BigDecimal score;

    private Date createTime;

    private BigDecimal myScore;

    private Integer state;

    private Integer years;

    private Integer months;
    
    private String name;
    
    private List<MonthPlanNext> monthPlanNext;
    
    private String departmentname;
    
    private String leadership;
    
    

    public MonthPlan() {
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

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion == null ? null : conclusion.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getMyScore() {
        return myScore;
    }

    public void setMyScore(BigDecimal myScore) {
        this.myScore = myScore;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    public Integer getMonths() {
        return months;
    }

    public void setMonths(Integer months) {
        this.months = months;
    }

	public List<MonthPlanNext> getMonthPlanNext() {
		return monthPlanNext;
	}

	public void setMonthPlanNext(List<MonthPlanNext> monthPlanNext) {
		this.monthPlanNext = monthPlanNext;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	public String getLeadership() {
		return leadership;
	}

	public void setLeadership(String leadership) {
		this.leadership = leadership;
	}
}