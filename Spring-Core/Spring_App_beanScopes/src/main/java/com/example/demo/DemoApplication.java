package com.example.demo;
import org.springframework.context.*;
import org.springframework.context.support.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
//		SpringApplication.run(DemoApplication.class, args);
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		Department department = context.getBean("departmentBean",Department.class);
//		
		System.out.println("1 :"+department.getEmployee());
//		System.out.println("2 :"+department.getEmployee());
//		System.out.println("3 :"+department.getEmployee());
	}

}
