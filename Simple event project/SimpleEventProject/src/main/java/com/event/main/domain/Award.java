package com.event.main.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Award {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	private String  employeeAward;
	private String awardName;
	public Award(long id, String employeeAward, String awardName) {
		super();
		this.id = id;
		this.employeeAward = employeeAward;
		this.awardName = awardName;
	}
	public Award() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmployeeAward() {
		return employeeAward;
	}
	public void setEmployeeAward(String employeeAward) {
		this.employeeAward = employeeAward;
	}
	public String getAwardName() {
		return awardName;
	}
	public void setAwardName(String awardName) {
		this.awardName = awardName;
	}
	@Override
	public String toString() {
		return "Award [id=" + id + ", employeeAward=" + employeeAward + ", awardName=" + awardName + "]";
	}
	
	

}
