package com.example.inmemory;


import java.sql.PreparedStatement;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component("usingMultipleBatch")
public class UsingMultipleBatch {
	
	@Autowired
	private EmployeeRepository repo;
	
	private JdbcTemplate jdbcTemplate;

	UsingMultipleBatch(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	
	}
	
	public int[][] batchUpdate(final Collection<Employee> employees) {
		return
				this.jdbcTemplate.batchUpdate(
						
						"update employee_info set created_at = ? where id = ?",
						employees,
						10,
						(PreparedStatement ps , Employee employee)->{
							ps.setString(1, LocalDate.now().toString());
							ps.setInt(2,employee.getId());
						}
		);
	}
	
	public void printEmployee() {
		System.out.println("Before Batch Update:");
		final Collection<Employee> employee = repo.findAll();
		employee.forEach(System.out::println);
		
		int[][] returnValues = batchUpdate(employee);
		
		System.out.println("After Batch Update:");
		final List<Employee> updatedEmployee = repo.findAll();
		updatedEmployee.forEach(System.out::println);
		
		System.out.println("return values:");
		Arrays.stream(returnValues).forEach(empl->toString());
	}

}
