package com.example.resource;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component("resourceDep")
public class ResourceDependency {

	private Resource resource;
	
	ResourceDependency(@Value("${com.example}") Resource template){
		resource=template;
		System.out.println("resource loaded");
	}
	
	void print() throws IOException{
		File file = resource.getFile();
    	 Scanner sc = new Scanner(file);
    	 while (sc.hasNextLine())
           System.out.println(sc.nextLine()); 
	}
}
