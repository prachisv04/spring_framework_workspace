package com.example;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.beans.MutablePropertyValues;

import org.springframework.context.support.ClassPathXmlApplicationContext;
public class SpringAppBindingApplication {
	
	
	public static void main(String[] args) {
		
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		DataBinderExample ex = new DataBinderExample();
		
		DataBinder db = new DataBinder(ex);
		Student stud = context.getBean("student",Student.class);
		
		Errors errors = new BeanPropertyBindingResult(stud, "student");
		
		StudentValidator validator = new StudentValidator();
		ValidationUtils.invokeValidator(validator, stud, errors);
		
		if(errors.getErrorCount()==0) {
			System.out.println("No Errors found , binding ...");
			MutablePropertyValues pv = new MutablePropertyValues();
			pv.add("student",stud);
			pv.add("check", "done");
			
			
			
			db.bind(pv);
			if(db.getBindingResult().getErrorCount()==0) {
				System.out.println( ex.toString() );
			}
			else
				db.getBindingResult().getAllErrors().stream().forEach(System.out::println);
			
		}
		else {
			System.out.println("Errors found , binding cannot happen");
			System.out.println(errors.getAllErrors().get(0).getDefaultMessage());
		}
		context.close();
	}

}
