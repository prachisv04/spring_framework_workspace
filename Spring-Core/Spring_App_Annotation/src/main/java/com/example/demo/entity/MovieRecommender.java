package com.example.demo.entity;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

@Component("movieRecommender")
@Scope("prototype")
public class MovieRecommender {

	@Autowired
	@Resource(name="firstMovie")
	private MovieCatalog movieCatalog;

	public MovieCatalog getMovieCatalog() {
		return movieCatalog;
	}

	
	public void setMovieCatalog( MovieCatalog movieCatalog) {
		this.movieCatalog = movieCatalog;
	}
		
}
