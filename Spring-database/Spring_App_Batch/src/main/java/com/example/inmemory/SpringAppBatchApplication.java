package com.example.inmemory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.javafaker.Faker;

@SpringBootApplication
public class SpringAppBatchApplication implements CommandLineRunner{
	
	@Autowired
	UsingNamedParameterJdbcTemplate namedJdbcTemplate;
	@Autowired
	UsingMultipleBatch usingMultipleBatch ;
	@Autowired
	UsingJdbcTemplate usingJdbcTemplate ;
	@Autowired
	EmployeeRepository repo;
	@Autowired
	Faker fk;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringAppBatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++) {
			Employee employee = new Employee();
			employee.setFirstname(fk.name().firstName());
			employee.setLastname(fk.name().lastName());
			employee.setDOB(fk.date().toString());
			employee.setAge(fk.number().numberBetween(18, 60));
			repo.save(employee);
		}
		
	
		System.out.println( " Using Jdbc Template " );
		usingJdbcTemplate.printEmployee();
		
		System.out.println( " Using Jdbc Template " );
		namedJdbcTemplate.printEmployee();
		
		System.out.println( " Using Jdbc Template " );
		usingMultipleBatch.printEmployee();
		
	}

}
