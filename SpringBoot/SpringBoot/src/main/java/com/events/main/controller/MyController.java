package com.events.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.events.main.entity.Events;
import com.events.main.services.EventsService;


  @RestController
  public class MyController {
	
	@Autowired
	private EventsService eventsService;
	
	
	// Get the all Events
	@CrossOrigin("http://localhost:3000")
	@GetMapping("/events")
	public List<Events> getEvents()
	{
		return this.eventsService.getEvents();
		
	}
	
	
	//Get the particular Events
	@CrossOrigin
    @GetMapping("/events/{event_Id}")
    public Events getEvent(@PathVariable int event_Id)
    {
    	return this.eventsService.getEvents(event_Id);
    }
    
    
    
    //Add a new Events
	@CrossOrigin
    @PostMapping(path="/events", consumes = "application/json")
    public Events addEvents(@RequestBody Events event)
    {
    	return this.eventsService.addEvents(event);
    }
    
   
    
    //Update events using put request
	@CrossOrigin
    @PutMapping("/events")
    public Events updateEvents(@RequestBody Events event)
    {
    	return this.eventsService.updateEvents(event);
    }
    
    
    
    //delete the course
	@CrossOrigin
    @DeleteMapping("/events/{event_Id}")
    public ResponseEntity<HttpStatus> deleteEvent(@PathVariable int event_Id)
    {
    	try
    	{
    		this.eventsService.deleteEvent(event_Id);
    		return new ResponseEntity<>(HttpStatus.OK);
    	}
    	catch(Exception e)
    	{
    		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
}