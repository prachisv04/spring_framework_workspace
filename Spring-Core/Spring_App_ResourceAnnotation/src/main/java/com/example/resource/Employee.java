package com.example.resource;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

@Component("employee")
@Scope(value = "prototype")
public class Employee {

	private int id;
	private String name;
	private String Designation;
	
	Employee(){
//		System.out.println("Employee Created:"+hashCode());
	}
	
	@Resource(name ="address")
	private Address address;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	
	@Lookup
	public Address getAddress() {
		return null;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "[id=" + id + ",name=" + name + ",Designation=" + Designation + " EmployeeAddress=" + address + "]";
	}
	
	
	
}
