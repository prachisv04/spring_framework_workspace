package com.spring;

import java.beans.ConstructorProperties;

public class Student {

	private  String name;
	private  int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public Student() {
		super();
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@ConstructorProperties({"name","age"})
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
	
	
}
