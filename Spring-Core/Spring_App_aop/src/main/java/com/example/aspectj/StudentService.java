package com.example.aspectj;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


@Component("service")
public class StudentService {
	
	List<Student> student;
	
	StudentService(){
		student = new ArrayList<Student>();
	}
	
	public void register(Student s) {
		student.add(s);
	}
	
	public List<Student> getStudents() {
		student.forEach(System.out::println);
		return student;	
	}
	
	public void deleteStudent(int id) throws StudentNotFound{
		
		int index=-1;
		for(int i=0;i<student.size();i++) {
			if(student.get(i).getId()==id) {
				index=i;
			}
		}
		if(index== -1)
			throw new StudentNotFound("Student with given id not found");
		else
		student.remove(index);
	}
	
	public void updateStudent(Student s) {
		for(int i=0;i<student.size();i++) {
			if(student.get(i).getId()==s.getId()) {
				student.remove(i);
				student.add(s);
			}
		}
	}
	
	
}
