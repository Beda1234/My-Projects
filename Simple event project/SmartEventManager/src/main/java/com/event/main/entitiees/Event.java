package com.event.main.entitiees;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Event")
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int eid;
	private String eventname;
	private String eventtitle;
	private String eventstartdate;
	private String eventenddate;
	private String eventimage;
	@Column(length = 1000)
	private String eventdescription;
	@ManyToOne
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEventname() {
		return eventname;
	}
	public void setEventname(String eventname) {
		this.eventname = eventname;
	}
	public String getEventtitle() {
		return eventtitle;
	}
	public void setEventtitle(String eventtitle) {
		this.eventtitle = eventtitle;
	}
	public String getEventstartdate() {
		return eventstartdate;
	}
	public void setEventstartdate(String eventstartdate) {
		this.eventstartdate = eventstartdate;
	}
	public String getEventenddate() {
		return eventenddate;
	}
	public void setEventenddate(String eventenddate) {
		this.eventenddate = eventenddate;
	}
	public String getEventimage() {
		return eventimage;
	}
	public void setEventimage(String eventimage) {
		this.eventimage = eventimage;
	}
	public String getEventdescription() {
		return eventdescription;
	}
	public void setEventdescription(String eventdescription) {
		this.eventdescription = eventdescription;
	}
	

	
		
		
		
		
		
	


}
