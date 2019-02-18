package com.schedule.model;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Events {
	
	private Integer id;

	private String title;
	
	private Date start;
	
	private Date end;
	
	private String color;
	
				public Events(Integer id, String title, Date start, Date end,String color) {
		super();
		this.id = id;
		this.title = title;
		this.start = start;
		this.end = end;
		this.color=color;
	}

				
				
	public String getColor() {
					return color;
				}



				public void setColor(String color) {
					this.color = color;
				}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	
}
