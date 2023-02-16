package com.event.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.event.main.domain.Event;
@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

}
