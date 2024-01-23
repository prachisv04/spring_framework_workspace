package com.example.resource;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

@Component("department")
@Scope(value = "prototype")
public class Department {
	
	private Employee employee;
	
	private Address address;
	
	Department(){
//		System.out.println("Department Created :"+hashCode());
	}
	
	@Lookup
	public Employee getEmployee() {
		return null;
	}

	@Resource(name="employee")
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Lookup
	public Address getAddress() {
		return null;
	}

	@Resource(name="address")
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "\n[Employee=" + employee + "DepartmentAddress=" + address + "]";
	}
	
	
}
