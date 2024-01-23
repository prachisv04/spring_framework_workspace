package com.example.demo.entity;

public class Child extends Parent{

	private String myName;

	public Child() {
		super();
		System.out.println("child");
	}
	
	public String getMyName() {
		return myName;
	}

	public void setMyName(String myName) {
		this.myName = myName;
	}

	@Override
	public String toString() {
		return "Child [myName=" + myName + "]";
	}
	
	

	
		
}
