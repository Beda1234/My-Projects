package com.event.main.domain;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Event {
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String eventname;
    private String eventtitle;
    private String eventdiscription;
    private String eventstartdate;
    private String eventenddate;
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Event(Long id, String eventname, String eventtitle, String eventdiscription, String eventstartdate,
			String eventenddate) {
		super();
		this.id = id;
		this.eventname = eventname;
		this.eventtitle = eventtitle;
		this.eventdiscription = eventdiscription;
		this.eventstartdate = eventstartdate;
		this.eventenddate = eventenddate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getEventdiscription() {
		return eventdiscription;
	}
	public void setEventdiscription(String eventdiscription) {
		this.eventdiscription = eventdiscription;
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
	
}
