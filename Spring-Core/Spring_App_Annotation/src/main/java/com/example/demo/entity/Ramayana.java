package com.example.demo.entity;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Lazy
public class Ramayana implements Movie{

	@Override
	public void run() {
	
			System.out.println("Ramanand Sagar Presents......Ramayan");
		
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Ramayan initialized");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Ramayan destroyed");
	}

}
