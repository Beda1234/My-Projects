package com.events.com.main;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Events {

	@Id
	private int date ;
	private String eventsName;
	private String eventsDetails ;
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public String getEventsName() {
		return eventsName;
	}
	public void setEventsName(String eventsName) {
		this.eventsName = eventsName;
	}
	public String getEventsDetails() {
		return eventsDetails;
	}
	public void setEventsDetails(String eventsDetails) {
		this.eventsDetails = eventsDetails;
	}
	public Events(int date, String eventsName, String eventsDetails) {
		super();
		this.date = date;
		this.eventsName = eventsName;
		this.eventsDetails = eventsDetails;
	}
	public Events() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Events [date=" + date + ", eventsName=" + eventsName + ", eventsDetails=" + eventsDetails + "]";
	}
}
