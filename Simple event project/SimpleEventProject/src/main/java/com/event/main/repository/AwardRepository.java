package com.event.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.event.main.domain.Award;

@Repository
public interface AwardRepository extends JpaRepository<Award, Long> {

}
