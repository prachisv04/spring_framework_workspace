package com.example;

// lets consider it as entity in out system to which we want to bind user input

public class DataBinderExample {
	
	Student student;
	String check;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	
	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

	@Override
	public String toString() {
		return "DataBinderExample = \n {\n\tstudent=" + student + ",\n\tcheck="+check +"\n  }";
	}
	
	
	
}
