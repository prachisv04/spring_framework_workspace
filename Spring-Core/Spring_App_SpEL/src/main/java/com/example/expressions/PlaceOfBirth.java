package com.example.expressions;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value="birth")
public class PlaceOfBirth {
	private String city;
	
	//using standard context bean , annotation configuration using SpEL
	 @Value("#{ systemProperties['user.country'] }")
	private String country;

	public PlaceOfBirth() {
		
		super();
	}

	public PlaceOfBirth(String city) {
		this.city=city;
	}

	public PlaceOfBirth(String city, String country) {
		this(city);
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String s) {
		this.city = s;
	}

	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
}
