package com.events.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.events.main.dao.EventsDao;
import com.events.main.entity.Events;

@Service
public class EventsServiceClass implements EventsService {
	
	@Autowired
	private EventsDao eventDao;
	
//	List<Events> list;
	
	public EventsServiceClass()
	{

	
	  
	}

	@Override
	public List<Events> getEvents() {

		return eventDao.findAll();
	}

	@Override
	public Events getEvents(int event_Id) {
		return eventDao.getOne(event_Id);
		
	}
	@Override
	public Events addEvents(Events event) {

		eventDao.save(event);
		return event;
	}

	
	@Override
	public Events updateEvents(Events event) {

		
		eventDao.save(event);
		return event;
	}

	
	@Override
	public Events deleteEvent(int event_Id) {

		Events event =eventDao.getOne(event_Id);
		eventDao.delete(event);
		return null;
	}

	

	
	}

