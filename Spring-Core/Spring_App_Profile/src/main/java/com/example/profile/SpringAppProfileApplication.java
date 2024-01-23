package com.example.profile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.profile.byComponent.AppConfig;
import com.example.profile.byComponent.ITComp;
import com.example.profile.byConfig.HR;
import com.example.profile.byConfig.HRConfig;
import com.example.profile.byConfig.IT;
import com.example.profile.byConfig.ITConfig;

@SpringBootApplication
public class SpringAppProfileApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAppProfileApplication.class, args);
		
//		BY CONFIGURATION 
//		 AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//		 System.setProperty("spring.profiles.active", "it");
//		 context.register(ITConfig.class);
//		 context.register(HRConfig.class);
//		 context.refresh();
//		 IT it1 = context.getBean("itBean",IT.class);
//		 IT it2 = context.getBean("itBean",IT.class);
//		 System.out.println( it1.hashCode());
//		 System.out.println( it2.hashCode());
//		 context.close();
		
		
		// BY COMPONENT
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.getEnvironment().setActiveProfiles("it");
		context.register(AppConfig.class);
		context.refresh();
		ITComp it1 = context.getBean("it",ITComp.class);
		ITComp it2 = context.getBean("it",ITComp.class);
		
		System.out.println(it1.hashCode());
		System.out.println(it2.hashCode());
		
	}

}
