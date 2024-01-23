package com.example;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component("studentValidator")
public class StudentValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Student.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
	
			Student stud = (Student) target;
			ValidationUtils.rejectIfEmpty(errors, "name", "101","Name is Null");
			
			if(stud.getId()<=0) {
				System.out.println("Id value not allowed");
				errors.reject("405", "Not Allowed");
			}

			
		
	}

	

}
