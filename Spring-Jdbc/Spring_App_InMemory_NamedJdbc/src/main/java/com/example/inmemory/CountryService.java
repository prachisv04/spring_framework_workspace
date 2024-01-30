package com.example.inmemory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CountryService {
	
	@Autowired
		private CountryRepository repository;

	CountryService(){

	}

	public void saveCountry(Country country){
		repository.saveCountry(country);
	}
	
	public void findAllCountries() {
		System.out.println();
		System.out.println("Countries:");
		repository.findAllCountry().forEach(country-> System.out.println(country.toString()));
		
		System.out.println();
	}
}
