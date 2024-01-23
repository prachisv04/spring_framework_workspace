package test;

import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.Student;

public class TestStudent {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Student student = (Student)context.getBean("studentbean");
		System.out.println( student.toString());
	}

}

