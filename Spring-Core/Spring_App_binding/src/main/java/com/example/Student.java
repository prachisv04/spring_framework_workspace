package com.example;


// lets consider it as request object that we are getting as user input

public class Student {
	
	private int id;
	private String name;
	private StudentType type;
	Student(){
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public StudentType getType() {
		return type;
	}
	public void setType(StudentType type) {
		this.type = type;
	}
	public Student(int id, String name,StudentType type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", type=" + type + "]";
	}
	
	
	

}
