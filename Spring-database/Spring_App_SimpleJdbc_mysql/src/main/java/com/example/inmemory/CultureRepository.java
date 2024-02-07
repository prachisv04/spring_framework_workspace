package com.example.inmemory;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class CultureRepository {

	private SimpleJdbcInsert jdbc;
	private SimpleJdbcCall jdbcCall;
	
	@Autowired
	public void setSimpleJdbcInsert(DataSource dataSource) {
		this.jdbc = new SimpleJdbcInsert(dataSource).withTableName("Culture");
		
		JdbcTemplate template =  new JdbcTemplate(dataSource);
		jdbcCall = new SimpleJdbcCall(template)
				.withProcedureName("getCultureByName")
				.useInParameterNames("org")
				.declareParameters(
						new SqlParameter("org", Types.VARCHAR),
						new SqlOutParameter("out_religion", Types.VARCHAR),
						new SqlOutParameter("out_language", Types.VARCHAR),
						new SqlOutParameter("out_book", Types.VARCHAR)
				);
		
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
	
	public Culture getCultureByName(String origin) {
		Culture c = new Culture();
		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("org", origin);
		Map<String, Object> out = jdbcCall.execute(in);
		c.setCountry(origin);
		c.setReligion(out.get("out_religion").toString());
		c.setLanguage(out.get("out_language").toString());
		c.setBook(out.get("out_book").toString());
		return c;
	}
	
	
	
	
}
