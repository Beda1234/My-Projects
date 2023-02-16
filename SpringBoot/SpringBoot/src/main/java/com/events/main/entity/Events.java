package com.events.main.entity;



import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@javax.persistence.Entity
public class Events {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int event_Id;
	@JsonFormat(pattern="dd/mm/yyyy",shape = Shape.STRING)
//	@Column(name="")
	private String event_Date ;
	private String event_Name;
	private String event_Description;
	public Events(int event_Id, String event_Date, String event_Name, String event_Description) {
		super();
		this.event_Id = event_Id;
		this.event_Date = event_Date;
		this.event_Name = event_Name;
		this.event_Description = event_Description;
	}
	public Events() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getEvent_Id() {
		return event_Id;
	}
	public void setEvent_Id(int event_Id) {
		this.event_Id = event_Id;
	}
	public String getEvent_Date() {
		return event_Date;
	}
	public void setEvent_Date(String event_Date) {
		this.event_Date = event_Date;
	}
	public String getEvent_Name() {
		return event_Name;
	}
	public void setEvent_Name(String event_Name) {
		this.event_Name = event_Name;
	}
	public String getEvent_Description() {
		return event_Description;
	}
	public void setEvent_Description(String event_Description) {
		this.event_Description = event_Description;
	}
	@Override
	public String toString() {
		return "Events [event_Id=" + event_Id + ", event_Date=" + event_Date + ", event_Name=" + event_Name
				+ ", event_Description=" + event_Description + "]";
	}
	
	
}