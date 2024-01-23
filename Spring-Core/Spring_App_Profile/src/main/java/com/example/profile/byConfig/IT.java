package com.example.profile.byConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class IT extends Department{
	
	Department department;
	
	IT(){
		department = new Department();
		department.setId(1);
		department.setName("IT");
		department.setLocation("PUNE");
		department.setManager("ME");
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
}
