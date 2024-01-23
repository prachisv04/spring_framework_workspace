package com.example.demo;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.Lifecycle;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("employeeBean")
@Scope(value="prototype")
public class Employee implements Lifecycle , InitializingBean , DisposableBean{

	private String name;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void start() {
		
		System.out.println("new employee started");
		
	}

	@Override
	public void stop() {
		
		System.out.println("end");		
	}

	@Override
	public boolean isRunning() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		
		System.out.println("new employee started - properties set");
		
	}

	@Override
	public void destroy() throws Exception {
		
		System.out.println(" employee destroyed.");
		
	}
	
	
	
}
