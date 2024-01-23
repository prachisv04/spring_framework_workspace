package com.example.demo.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.example.demo.entity")
@PropertySource("classpath:application.properties")
public class MovieCatalogConfiguration {

    @Bean("firstMovie")
    MovieCatalog getMovieCatalogFirst() {
		MovieCatalog movieCatalog = new MovieCatalog();
//		movieCatalog.setMovieName("Ramayan");
		return  movieCatalog;
		
	}

    @Bean
    @Primary
    MovieCatalog getMovieCatalogSecond() {
		
		MovieCatalog movieCatalog = new MovieCatalog();
		movieCatalog.setMovieName("Mahabharat");
		return  movieCatalog;
		
	}
	
}
