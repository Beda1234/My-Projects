package com.events.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.events.main.entity.Events;

public interface EventsDao extends JpaRepository<Events , Integer>
{
	

}
