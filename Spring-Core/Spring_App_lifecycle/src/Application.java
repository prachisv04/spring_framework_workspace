

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.custombean.entity.School;
import com.java.custombean.entity.Student;

public class Application {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new
					ClassPathXmlApplicationContext("beans.xml");
		
//		Student s = context.getBean("studentBean",Student.class);
//		context.close();
		
//		School school = context.getBean("schoolBean",School.class);
		context.refresh();
	}

}
