package com.dependencies.entity;
import org.springframework.context.support.*;
import org.springframework.context.ApplicationContext;

public class Application {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Student student = context.getBean("studentBean",Student.class);
		System.out.println(student);
		
		
	}
}

/*
	Explanation : 
		
	IDREF : 
		
	Instead of sending string literal to get bean , we can use variables that dynamically takes values 
	from xml file , so even if we change values in xml we don't have to make changes in java code this will 
	reduce dependency
	doing so is possible by sending value using Constructor are or property but even in that case we
	cannot make sure that the bean exists with a name passed.
	to validate the bean name before injecting we can use idref , if we use idref bean with given name 
	exists , then only program will execute otherwise we will get to see BeanCreationException compile
	time instead of getting it in run time in other case.
	
	
*/