package com.example.demo;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.entity.MovieCatalog;
import com.example.demo.entity.MovieCatalogConfiguration;
import com.example.demo.entity.MovieRecommender;
import com.example.demo.entity.MovieSuggestion;

@SpringBootApplication
public class SpringAppAnnotationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAppAnnotationApplication.class, args);
		
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MovieCatalogConfiguration.class);
		
		// Primary
		System.out.println("+ Using @Primary");
		MovieRecommender m = context.getBean("movieRecommender",MovieRecommender.class);
		System.out.println("Consider watching : "+ m.getMovieCatalog().getMovieName());
		
		//Qualifier
		System.out.println("+ Using @Qualifier");
		MovieCatalog cat = context.getBean("movieCatalog",MovieCatalog.class);
		cat.watching();
		
		context.close();
		
	}

}
