package com.example.inmemory;

import java.util.Arrays;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;


@Component("usingNamedParameterJdbcTemplate")
public class UsingNamedParameterJdbcTemplate {

	@Autowired
	private EmployeeRepository repo;
	
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	UsingNamedParameterJdbcTemplate(DataSource dataSource){
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public int[] batchUpdate(final List<Employee> employees) {
		
		return
				this.jdbcTemplate.batchUpdate(
						"update employee_info set age = :age+2 where id = :id",
						SqlParameterSourceUtils.createBatch(employees));
	}
	
	public void printEmployee() {
		System.out.println("Before Batch Update:");
		final List<Employee> employee = repo.findAll();
		employee.forEach(System.out::println);
		
		int[] returnValues = batchUpdate(employee);
		
		System.out.println("After Batch Update:");
		final List<Employee> updatedEmployee = repo.findAll();
		updatedEmployee.forEach(System.out::println);
		
		System.out.println("return values:");
		Arrays.stream(returnValues).forEach(empl->toString());
	}
	
}
