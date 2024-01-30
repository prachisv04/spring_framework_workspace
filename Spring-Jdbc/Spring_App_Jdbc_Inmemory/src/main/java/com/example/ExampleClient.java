package com.example;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ExampleClient{

	private static JdbcTemplate jdbcTemplate;
	
	@Autowired
	private PersonRepository repo;
	
	 public void save(Person person) {
		 repo.save(person);
	  }

	  public List<Person> loadAll() {
	     return repo.loadAll();
	  }

	public void run(JdbcTemplate jdbctemplate) {
		jdbcTemplate = jdbctemplate;
		 jdbcTemplate.execute("DROP TABLE customers IF EXISTS");
		    jdbcTemplate.execute("CREATE TABLE Person(" +
		        "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255),address VARCHAR(255))");
	  }
}
