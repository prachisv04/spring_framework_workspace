package com.example.resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAppResourceAnnotationApplication {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		CompanyService company = context.getBean("company",CompanyService.class);
		System.out.println("======================================================================");
		System.out.println(company.toString());
		
		
//		System.out.println("=========================================================================");
//		ApplicationContext ctx = new AnnotationConfigApplicationContext(CompanyConfig.class);
//		CompanyService company2 = ctx.getBean("company",CompanyService.class);
//		System.out.println(company2.toString());
				
	}

}
