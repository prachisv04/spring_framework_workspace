

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring_App_SI_DI.entity.Student;

public class StudentTest {

	public static void main(String args[]) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Student student = (Student) context.getBean("studentbean");
		System.out.println(student.toString());
		
	}
	

}
