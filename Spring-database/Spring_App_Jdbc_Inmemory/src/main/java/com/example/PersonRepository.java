package com.example;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepository {
	
	@Autowired
	private  JdbcTemplate jdbcTemplate;
	
	@Autowired
	private JdbcClient jdbcClient ;

	
	public void save(Person person) {
		 String sql = "insert into Person (firstName, lastName, address) values (?, ?, ?)";
	      jdbcTemplate.update(sql, person.getFirstName(), person.getLastName(),
	              person.getAddress());
	}
	
	public long saveWIthKey(Person person) {
		
		GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
		 String sql = "insert into Person (firstName, lastName, address) values (?, ?, ?)";
	    jdbcTemplate.update(connection -> {
	        PreparedStatement ps = connection
	          .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	          ps.setString(1, person.getFirstName());
	          ps.setString(2,person.getLastName());
	          ps.setString(3,person.getAddress());
	          return ps;
	        }, keyHolder);
	        return Integer.valueOf(keyHolder.getKey().toString());
	
	}

	public List<Person> loadAll() {
		 return jdbcTemplate.query("select * from Person", (resultSet, i) -> {
	          return toPerson(resultSet);
	      });
		
	}
	private Person toPerson(ResultSet resultSet) throws SQLException {
	      Person person = new Person();
	      person.setId(resultSet.getLong("ID"));
	      person.setFirstName(resultSet.getString("FIRSTNAME"));
	      person.setLastName(resultSet.getString("LASTNAME"));
	      person.setAddress(resultSet.getString("ADDRESS"));
	      return person;
	  }
	
	public void updatePerson(long id , Person p) {
		if(p!=null) {
			jdbcClient.sql("update Person set firstName=:first_name, lastName=:last_name,address=:address where id=:id")
			.param("id",id).param("first_name",p.getFirstName()).param("last_name", p.getLastName()).param("address", p.getAddress())
			.update();
		}
		else
			System.out.println("person with id "+id+" is not available");
	}
	
	

}
