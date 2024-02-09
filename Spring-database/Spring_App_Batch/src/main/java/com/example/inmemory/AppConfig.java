package com.example.inmemory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.github.javafaker.Faker;


@Configuration 
@ComponentScan("com.batch")
public class AppConfig {
	
	@Bean
	Faker faker() {
		return new Faker();
	}
	
}
