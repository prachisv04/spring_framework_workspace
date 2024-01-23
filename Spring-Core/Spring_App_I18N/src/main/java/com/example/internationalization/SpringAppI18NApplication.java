package com.example.internationalization;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractResourceBasedMessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAppI18NApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAppI18NApplication.class, args);
		
//		
		
		MessageSource resources = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println(resources.getMessage("language",
				null, "Missing Information", Locale.UK));
		System.out.println(resources.getMessage("code",
				null, "Missing Information", Locale.FRANCE));
		System.out.println(resources.getMessage("text",
				null, "Missing Information", Locale.FRANCE));
	}

}
