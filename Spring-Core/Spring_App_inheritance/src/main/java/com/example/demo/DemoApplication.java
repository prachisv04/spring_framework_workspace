package com.example.demo;

import org.springframework.context.*;
import org.springframework.context.support.*;

import com.example.demo.entity.Child;
import com.example.demo.entity.Parent;

public class DemoApplication {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Parent p = context.getBean("parentBean",Parent.class);
		Child c = context.getBean("childBean",Child.class);
		
		System.out.println(c.getParentName());
	}

}
