package com.event.main.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.event.main.entitiees.User;


public interface EventRepository extends JpaRepository<User, Integer> {

}
