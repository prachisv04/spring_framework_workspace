package com.example.events;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringAppEventsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAppEventsApplication.class, args);
		
		ClassPathXmlApplicationContext context = 
		         new ClassPathXmlApplicationContext("beans.xml");
		
		EmailService service = context.getBean("emailService",EmailService.class);
		service.sendEmail("prachisv03@gmail.com", "This Email is Blocked");
		service.sendEmail("prachisv05@gmail.com", "This Email is Blocked");
		service.sendEmail("prachisv02@gmail.com", "This Email is Blocked");
		service.sendEmail("prachisv07@gmail.com", "This Email is Blocked");
			
	}

}
