package com.plan.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class YearPlan {
    private Integer yid;

    private Integer uid;

    private String remarks;

    private Date createTime;

    private String year;
    
    private String name;
    
    private List<YearPlanNext> yearPlanNext;

    private Date create_time;
    
    private String departmentname;
    
    private String[] files;
    public Integer getYid() {
        return yid;
    }

    public void setYid(Integer yid) {
        this.yid = yid;
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
 
   
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	 @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	 @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public List<YearPlanNext> getYearPlanNext() {
		return yearPlanNext;
	}

	public void setYearPlanNext(List<YearPlanNext> yearPlanNext) {
		this.yearPlanNext = yearPlanNext;
	}

	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	public String[] getFiles() {
		return files;
	}

	public void setFiles(String[] files) {
		this.files = files;
	}
}