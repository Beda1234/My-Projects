package com.event.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event.main.domain.Event;
import com.event.main.repository.EventRepository;



@Service
public class EventService {
	@Autowired
	private EventRepository repo;
	
	public List<Event> listAll(){
		return repo.findAll();
	}
	public void save(Event std) {
		repo.save(std);
	}
	public Event get(long id) {
		return repo.findById(id).get();
	}
	public void delete(long id) {
		repo.deleteById(id);
	}

}
