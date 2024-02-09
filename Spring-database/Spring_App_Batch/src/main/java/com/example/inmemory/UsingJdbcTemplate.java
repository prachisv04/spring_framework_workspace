package com.example.inmemory;

import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

@Component("usingJdbcTemplate")
public class UsingJdbcTemplate {
	
	@Autowired
	private EmployeeRepository repo;
	
	private JdbcTemplate jdbcTemplate;
	
	UsingJdbcTemplate(DataSource dataSource,Faker faker){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public int[] batchUpdate(final List<Employee> employees) {
		return
				this.jdbcTemplate.batchUpdate(
						
						"update employee_info set Name = ? where id = ?",
						new BatchPreparedStatementSetter() {
							public void setValues(PreparedStatement ps , int i) throws SQLException{
								Employee employee = employees.get(i);
								ps.setString(1, employee.getFirstname()+" "+employee.getLastname());
								ps.setInt(2, employee.getId());
							}
							public int getBatchSize() {
								return employees.size();
							}
						}
		);
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
