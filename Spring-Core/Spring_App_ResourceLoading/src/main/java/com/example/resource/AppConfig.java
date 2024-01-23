package com.example.resource;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.example.resource")
@PropertySource("application.properties")
public class AppConfig {
	
	

}
