package com.plan.model;

import java.util.Date;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonFormat;

public class WeeksPlan {
    private Integer wid;

    private Integer uid;

    private String remarks;

    private Date createTime;

    private int years;
    
    private int weeks;
    
    private int months;
   
    private String name ;
    
    private String departmentname;
    
    private int type;
    

    private List<WeeksPlanNext> weekplan;
    
    private String leadershipname ;
    
    private String principalname;
    
    private List<WeeksPlanNext> WeeksPlanNext;
    
    private Date Monday ;
    
    private Date Sunday ;

 

	

    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	public Date getMonday() {
		return Monday;
	}


	public void setMonday(Date monday) {
		Monday = monday;
	}

	 @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	public Date getSunday() {
		return Sunday;
	}


	public void setSunday(Date sunday) {
		Sunday = sunday;
	}


	public WeeksPlan(){}
   

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}

	public int getWeeks() {
		return weeks;
	}

	public void setWeeks(int weeks) {
		this.weeks = weeks;
	}

	public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMonths() {
		return months;
	}

	public void setMonths(int months) {
		this.months = months;
	}

	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public List<WeeksPlanNext> getWeekplan() {
		return weekplan;
	}

	public void setWeekplan(List<WeeksPlanNext> weekplan) {
		this.weekplan = weekplan;
	}

	

	public String getPrincipalname() {
		return principalname;
	}

	public void setPrincipalname(String principalname) {
		this.principalname = principalname;
	}

	public String getLeadershipname() {
		return leadershipname;
	}

	public void setLeadershipname(String leadershipname) {
		this.leadershipname = leadershipname;
	}


	public List<WeeksPlanNext> getWeeksPlanNext() {
		return WeeksPlanNext;
	}


	public void setWeeksPlanNext(List<WeeksPlanNext> weeksPlanNext) {
		WeeksPlanNext = weeksPlanNext;
	}

   
}