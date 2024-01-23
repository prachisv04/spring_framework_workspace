package com.example.aspectj;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;;

public class SpringAppAopApplication {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		StudentService service = context.getBean("service",StudentService.class);
		
		Student s1 = new Student();
		
		s1.setId(1);
		s1.setName("India");
		s1.setDepartment("History");
		
		service.register(s1);
		
		service.getStudents();
		try {
		service.deleteStudent(-1);
		}
		catch(StudentNotFound f) {
			
		}
		service.updateStudent(s1);
		context.close();
	}

}
