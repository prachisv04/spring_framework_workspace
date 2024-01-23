package com.example.demo.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("movieCatalog")
public class MovieCatalog {
	
	@Autowired
	@Qualifier("mahabharat")
	private Movie movie;
	
	@Value("${catalog.name}")
	private String movieName;
	
		public MovieCatalog() {
			super();
		}
	
		public String getMovieName() {
			return movieName;
		}
	
		public void setMovieName( String movieName) {
			
			this.movieName = movieName;
		}

		public Movie getMovie() {
			return movie;
		}

		public void setMovie(Movie movie) {
			this.movie = movie;
		}
		public void watching() {
			movie.run();
		}
}
