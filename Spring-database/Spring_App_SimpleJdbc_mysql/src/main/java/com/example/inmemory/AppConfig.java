package com.example.inmemory;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.inmemory")
public class AppConfig {
	
	 @Bean
	     DataSource getDataSource() {
		 System.out.println("datasource created");
	        return DataSourceBuilder.create()
	          .driverClassName("com.mysql.cj.jdbc.Driver")
	          .url("jdbc:mysql://localhost:3306/geography")
	          .username("root")
	          .password("root123")
	          .build();	
	    }

}
