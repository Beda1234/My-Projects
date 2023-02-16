package com.events.main.services;

import java.util.List;

import com.events.main.entity.Events;

public interface EventsService {
	
	//This is collect for list of events
	public List<Events> getEvents();
	
	//This is collect the single event
	public Events getEvents(int event_Id);
	
	// This is for add a new event
	public Events addEvents(Events event);
	
	//This is for update the event
	public Events updateEvents(Events event);
	
	//This is for delete the event
	public Events deleteEvent(int event_Id);
	

}