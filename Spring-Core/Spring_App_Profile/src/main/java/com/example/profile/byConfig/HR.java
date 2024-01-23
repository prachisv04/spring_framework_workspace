package com.example.profile.byConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class HR extends Department{
	
	
	private Department department;
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	HR(){
		department = new Department();
		department.setId(2);
		department.setName("HR");
		department.setLocation("NASHIK");
		department.setManager("NOT ME");
	}

	

	
}
