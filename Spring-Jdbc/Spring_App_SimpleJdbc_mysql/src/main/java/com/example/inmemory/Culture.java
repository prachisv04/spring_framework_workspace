package com.example.inmemory;

import org.springframework.stereotype.Component;

@Component
public class Culture {
	
	private String country;
	private String religion;
	private String language;
	private String book;
	
	Culture(){
		System.out.println("culture established");
	}
	
	public Culture(String country, String religion, String language, String book) {
		super();
		this.country = country;
		this.religion = religion;
		this.language = language;
		this.book = book;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getBook() {
		return book;
	}
	public void setBook(String book) {
		this.book = book;
	}
	
	@Override
	public String toString() {
		return "country{\n\tname=" + country + ",\n\treligion=" + religion + ",\n\tlanguage=" + language + ",\n\tbook=" + book
				+ "\n}";
	}

	
	
}
