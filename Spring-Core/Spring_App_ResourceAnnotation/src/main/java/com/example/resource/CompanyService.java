package com.example.resource;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

@Component("company")
@Scope("singleton")
public class CompanyService {

	private String name;
	
	@Resource
	private Department department;
	
	@Resource
	private Address address;
	
	CompanyService(){
//		System.out.println("company Created: " +toString());
	}

	@Lookup
	public Department getDepartment() {
		return null;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Lookup
	public Address getAddress() {
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "CompanyService [\nname=" + name + "\nDepartment=" + department + "\nCompanyAddress=" + address + "\n]";
	}
	
	
	
}
