package com.example.inmemory;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CountryRepository {
	
	private final NamedParameterJdbcTemplate jdbcTemplate;
	
	CountryRepository(NamedParameterJdbcTemplate template){
		this.jdbcTemplate=template;
			jdbcTemplate.execute("DROP TABLE customers IF EXISTS" , new PreparedStatementCallback<Integer>() {
				@Override
				public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
					// TODO Auto-generated method stub
					return ps.executeUpdate();
				}
				
			});
		    jdbcTemplate.execute("CREATE TABLE Country(" +
		        "id SERIAL, name VARCHAR(255), capital VARCHAR(255),population int)", new PreparedStatementCallback<Integer>() {
				@Override
				public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
					// TODO Auto-generated method stub
					return ps.executeUpdate();
				}	
			});
	}

	public void saveCountry(Country country){
		String sql = "insert into Country (name, capital, population) values (:name,:capital,:population)";
		
		 MapSqlParameterSource in = new MapSqlParameterSource();
		 in.addValue("name",country.getName());	 
		 in.addValue("capital",country.getCapital());
		 in.addValue("population",country.getPopulation());
		 
	      jdbcTemplate.update(sql,in);
	}
	
	public List<Country> findAllCountry(){
		List<Country> countries = new ArrayList<Country>();
		jdbcTemplate.query("SELECT * FROM COUNTRY", 
				(rs,rowNum)->new Country(rs.getLong("id"),rs.getString("name"),rs.getString("capital"),rs.getLong("population")))
				.forEach(country->countries.add(country));
		return countries;
	}
}
