package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringAppJdbcInmemoryApplication implements CommandLineRunner{
	 @Autowired
	  private ExampleClient exampleClient;

	 @Autowired
	 private JdbcTemplate template;

	  public static void main(String[] args) {
	      SpringApplication sa = new SpringApplication(SpringAppJdbcInmemoryApplication.class);
	      sa.run(args);
	  }

	  @Override
	  public void run(String... args) {
	      exampleClient.run(template);
	      
	      Person person = new Person("Dana", "Whitley", "464 Yellow Drive");
	      exampleClient.save(person);

	      person = new Person("Robin", "Cash", "64 Logic Park");
	      long id = exampleClient.saveWithKey(person);
	      System.out.println("id:"+id);
	      
	      System.out.println("-- loading all --");
	      List<Person> persons = exampleClient.loadAll();
	      persons.forEach(per->System.out.println(per.toString()));
	      
	      	//	      updating user with id 
	      
	      person = new Person("Robin", "Scherbatsky", "64 Logic Park");
	      exampleClient.update(id, person);
	      
	      System.out.println("-- loading all --");
	       persons = exampleClient.loadAll();
	      persons.forEach(per->System.out.println(per.toString()));
	  }

}
