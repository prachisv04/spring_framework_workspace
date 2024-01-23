package com.dependencies.entity;

import java.util.Map;
import java.util.HashMap;

public class Courses {

	Map<String,Integer> courses = new HashMap<String,Integer>();
//	key will be course name and value will be credits

	public Map<String, Integer> getCourses() {
		return courses;
	}

	public void setCourses(Map<String, Integer> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Courses [courses=" + courses + "]";
	}
	
	
	
}
