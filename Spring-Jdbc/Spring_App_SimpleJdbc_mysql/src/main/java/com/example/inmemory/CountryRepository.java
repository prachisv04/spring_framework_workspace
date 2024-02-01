package com.example.inmemory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
@Repository
public class CountryRepository {

	@Autowired
	private JdbcTemplate template ;
	
	
	CountryRepository(){
		System.out.println("country repository created ");
	}
	
	public void saveCountry(Country country) throws IOException{
		
		LobHandler lobhandler =new DefaultLobHandler();;
		template.execute(
				"INSERT INTO country (name, flag , constitution_title) VALUES (?, ? , ?)",
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {  
					protected void setValues(PreparedStatement ps, LobCreator lobCreator) throws SQLException {
						ps.setString(1,country.getName());
						lobCreator.setBlobAsBytes(ps, 2,country.getFlag());
//						lobCreator.setBlobAsBinaryStream(ps, 2, blobIs, (int)blobIn.length());
						ps.setString(3,country.getConstitution_title());
					}
				}
			);

	}
	
	public Country getCountry(String name) {
		String sql= "SELECT name,flag,constitution_title from country where name=?";
		Country country = template.queryForObject(sql, 
				(rs,rowNum)-> new Country(rs.getString("name"),rs.getBytes("flag"),rs.getString ("constitution_title")),name );
		return country;
	}
	
}
