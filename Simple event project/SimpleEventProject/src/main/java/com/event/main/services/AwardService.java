package com.event.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event.main.domain.Award;
import com.event.main.repository.AwardRepository;


@Service
public class AwardService 
{
	@Autowired
	private AwardRepository repoos;
	
	public List<Award> listAll(){
		return repoos.findAll();
	}

	public void save(Award awd) {
		repoos.save(awd);
	}
	public Award get(long id) {
		return repoos.findById(id).get();
	}
	public void delete(long id) {
		repoos.deleteById(id);
	}
}
