package com.example.inmemory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class CultureRepository {

	
	private SimpleJdbcInsert jdbc;
	
	@Autowired
	public void setSimpleJdbcInsert(DataSource dataSource) {
		
		System.out.println(dataSource.toString());
		this.jdbc = new SimpleJdbcInsert(dataSource).withTableName("Culture");
	} 
	
	CultureRepository(){
		System.out.println("Repository Created");
	}
	
	public List<Culture> findAllCultures(){
		String sql= "SELECT origin,religion,Language,book from Culture";
		List<Culture> cultures = new ArrayList<Culture>();
		jdbc.getJdbcTemplate().query(sql, 
				(rs,rowNum)->new Culture(rs.getString("origin"),rs.getString("religion"),rs.getString("Language"),rs.getString("book")))
				.forEach(culture->cultures.add(culture));
		return cultures;
	}
	
	
	public void saveCulture(Culture culture) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("origin",culture.getCountry() );
		params.put("religion",culture.getReligion() );
		params.put("Language",culture.getLanguage() );
		params.put("book",culture.getBook() );
		
		jdbc.execute(params);
	}
}
