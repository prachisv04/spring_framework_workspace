package com.spring;

import org.springframework.beans.factory.*;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.*;

public class TestStudent {

	public static void main(String[] args) {

		Resource resource=new ClassPathResource("applicationContext.xml");
		BeanFactory factory=new XmlBeanFactory(resource);
		
		Student student = (Student)factory.getBean("studentbean2");
		System.out.println( student.toString());
	}

}
