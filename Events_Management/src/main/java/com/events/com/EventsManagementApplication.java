package com.events.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.events.com.dao.eventRepository;
import com.events.com.main.Events;

@SpringBootApplication
public class EventsManagementApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext context= SpringApplication.run(EventsManagementApplication.class, args);
	eventRepository eventRepository= context.getBean(eventRepository.class);
	Events event = new Events();
	event.setDate(10);
	event.setEventsName("Ganesh Puja");
	event.setEventsDetails("Anything");
	Events events =eventRepository.save(event);
	System.out.println(events);
	}

}
