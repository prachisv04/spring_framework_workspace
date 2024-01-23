package com.dependencies.entity;

import java.util.Objects;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Student {

	private int rollno;
	private String Name;
	private String address;
	private Courses course;
	
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Courses getCourse() {
		return course;
	}
	public void setCourse(Courses course) {
		this.course = course;
	}
	@Override
	public String toString() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Address addressBean = (Address) context.getBean(address);
		return "Student [rollno=" + rollno + ", Name=" + Name + ", address=" + addressBean + "\n courses=" + course + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(Name, rollno);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(Name, other.Name) && rollno == other.rollno;
	}
	
	
	
	
}
