package com.sys.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Propelling {
    private Date propellingTime;
    
    public Propelling(){}
    
    

    public Propelling(Date propellingTime) {
		super();
		this.propellingTime = propellingTime;
	}



	@JsonFormat(pattern="HH:mm:ss")
    public Date getPropellingTime() {
        return propellingTime;
    }

    public void setPropellingTime(Date propellingTime) {
        this.propellingTime = propellingTime;
    }
}