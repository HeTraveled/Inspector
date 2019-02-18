package com.home.model;

import java.math.BigDecimal;
import java.util.Date;

import com.dept.model.Dept;
import com.fasterxml.jackson.annotation.JsonFormat;

public class User {
    private Integer uid;

    private Integer rid;

    private String name;

    private String password;

    private String wechat;

    private Integer sex;

    private String tel;

    private String phone;

    private Integer did;

    private String headimg;

    private Integer state;

    private String address;

    private String e_mail;

    private Integer workState;

    private String job;

    private Date createTime;
    
    private BigDecimal score;
    
    private Dept dept;
    
    private String departmentname;
    
    private String  rname;
    
    private String orderby;
    
    private Integer numflag;
    
    private Date birth;

    private Integer special1;
    
    private Integer special2;
    
    private Integer prompt;
    
    private String employeeNo;
    
    
    
    
    
    public String getEmployeeNo() {
		return employeeNo;
	}
	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}
	public Integer getPrompt() {
		return prompt;
	}
	public void setPrompt(Integer prompt) {
		this.prompt = prompt;
	}
	public User(Integer uid,Integer special1){
    	this.uid=uid;
    	this.special1=special1;
    }
    public User(Integer uid,Integer special2,String flag){
    	this.uid=uid;
    	this.special2=special2;
    }
    public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	public User(){}
    
    public User(String phone,String password){
    	this.phone=phone;
    	this.password=password;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg == null ? null : headimg.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
    public Integer getWorkState() {
        return workState;
    }

    public void setWorkState(Integer workState) {
        this.workState = workState;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public String getOrderby() {
		return orderby;
	}

	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}

	public BigDecimal getScore() {
		return score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}

	public Integer getNumflag() {
		return numflag;
	}

	public void setNumflag(Integer numflag) {
		this.numflag = numflag;
	}
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Integer getSpecial1() {
		return special1;
	}

	public void setSpecial1(Integer special1) {
		this.special1 = special1;
	}

	public Integer getSpecial2() {
		return special2;
	}

	public void setSpecial2(Integer special2) {
		this.special2 = special2;
	}

    
}