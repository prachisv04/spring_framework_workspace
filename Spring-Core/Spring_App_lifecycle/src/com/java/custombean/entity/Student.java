package com.java.custombean.entity;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Student implements InitializingBean , DisposableBean{
	private String name;
	
	public Student() {
		super();
		System.out.println("Student Created");
	}
	
	
	public void init() {
		System.out.println("Student Initialization method");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterprop = " );
		init();
		
	}


	@Override
	public void destroy() throws Exception {
		
		System.out.println(" Student destroyed. ");
		
	}
	
}
