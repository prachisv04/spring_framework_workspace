package com.example.resource;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import org.springframework.core.io.Resource;
import org.springframework.context.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class SpringAppResourceLoadingApplication {

	public static void main(String[] args) throws IOException {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class) ;
	
System.out.println("\nUsing COntext as ResourceLoader -\n");
		
		System.out.println("\nget Resources from UrlResource -\n");
		
		Resource resource1 = context.getResource("url:http:/google/com/");
		
		System.out.println(resource1.getClass());
		
		System.out.println("\nget Resources from ClassPathResource  -\n");
		
		Resource resource2 = context.getResource("classpath:demo.txt");
		
		System.out.println(resource2.getClass());
		
		System.out.println("\nget Resources from FileUrlResource  -\n");
		
		Resource resource3 = context.getResource("file:demo.txt");
		
		System.out.println(resource3.getClass());
		
System.out.println("\n======================================================================");
		
System.out.println("\nGet Resource by implementing ResourceLoaderAware  -\n");
		
		Resource resource = context.getBean("cust",CustomerService.class).getResource("demo.txt");
	
		System.out.println(resource.getClass());
			
			 File file = resource.getFile();
	     	 Scanner sc = new Scanner(file);
	     	 while (sc.hasNextLine())
	            System.out.println(sc.nextLine());   
	  
		 sc.close();
		 
System.out.println("\n======================================================================");
			
System.out.println("\n	Resource As Dependency  -\n");
		 
		 context.getBean("resourceDep" , ResourceDependency.class).print();
}
}

