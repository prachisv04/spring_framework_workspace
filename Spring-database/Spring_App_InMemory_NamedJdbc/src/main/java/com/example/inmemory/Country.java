package com.example.inmemory;

import org.springframework.stereotype.Component;

@Component
public class Country {
	
	private long id;
	private String name;
	private String capital;
	private long population;
	
	Country(){
	}
	
	public Country(long id, String name, String capital, long population) {
		super();
		this.id = id;
		this.name = name;
		this.capital = capital;
		this.population = population;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public long getPopulation() {
		return population;
	}
	public void setPopulation(long population) {
		this.population = population;
	}
	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", capital=" + capital + ", population=" + population + "]";
	}
	

}
