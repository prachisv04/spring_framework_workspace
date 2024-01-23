package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

//@Component
//@Scope( value="prototype",proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Department {

	private String name;
	private int id;
	private String location;	
	private Employee employee;
	
	public Department() {
		System.out.println("Department created - "+hashCode());
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	@Lookup
	public Employee getEmployee() {
		return null;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
