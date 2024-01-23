package com.example;

import org.springframework.stereotype.Component;

@Component("studentType")
public class StudentType {
	
	private String type;
	private String department;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public StudentType(String type, String department) {
		super();
		this.type = type;
		this.department = department;
	}
	public StudentType() {
		super();
	}
	@Override
	public String toString() {
		return "StudentType [type=" + type + ", department=" + department + "]";
	}
	
	
	
}
