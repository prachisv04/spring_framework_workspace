package spring_App_SI_DI.entity;

import java.beans.ConstructorProperties;

public class Student {
	
	private String name;
	private int age;
	private Address address;
	private Exam exam;
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public int getAge() {
				return age;
			}
			public void setAge(int age) {
				this.age = age;
			}
			public Address getAddress() {
				return address;
			}
			public void setAddress(Address address) {
				this.address = address;
			}
			
	public Exam getExam() {
				return exam;
			}
			public void setExam(Exam exam) {
				this.exam = exam;
			}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", address=" + address + " and exam done]";
	}
	
//	@ConstructorProperties({"name","age","address","exam"})
	public Student(String name, int age, Address address, Exam exam) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
		this.exam = exam;
	}
	public Student() {
		super();
	}
	
	
	

}
