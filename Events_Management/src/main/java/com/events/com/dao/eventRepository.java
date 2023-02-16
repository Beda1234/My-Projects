package com.events.com.dao;

import org.springframework.data.repository.CrudRepository;

import com.events.com.main.Events;

public interface eventRepository extends CrudRepository<Events, Integer>{
	
	

}
