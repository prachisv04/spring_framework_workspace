package com.java.custombean.entity;

import org.springframework.context.Lifecycle;

public class School implements Lifecycle{
	
	private String name;
	private Student student;

	public School() {
		super();
		System.out.println("School Created");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean isRunning() {
		
		return true;
	}

	@Override
	public void start() {
		
		System.out.println(" lifecycle started ");
		
	}

	@Override
	public void stop() {
		
		System.out.println(" lifecycle ended ");
		
	}

	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	

}
