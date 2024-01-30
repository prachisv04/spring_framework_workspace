package com.example.inmemory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringAppInMemoryNamedJdbcApplication {
	
	
	@Autowired
		private CountryService service;

	public static void main(String[] args) {
		
		SpringAppInMemoryNamedJdbcApplication app = new SpringAppInMemoryNamedJdbcApplication();
		app.check();
		
	}

	public void check() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
	
		    
		service = context.getBean("countryService",CountryService.class);
		service.saveCountry(new Country(1,"India","New Delhi",13400000));
		service.saveCountry(new Country(2,"UK","London",1400000));
		service.findAllCountries();
		context.close();
	}
}
