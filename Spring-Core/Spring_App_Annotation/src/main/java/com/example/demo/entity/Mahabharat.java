package com.example.demo.entity;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Lazy
public class Mahabharat implements Movie {

	@Override
	public void run() {
		
		System.out.println("B.R.Chopra presents .......mahabharat");

	}

	@PostConstruct
	public void init() {
		System.out.println("Mahabharat initialized");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Mahabharat destroyed");
	}
}
