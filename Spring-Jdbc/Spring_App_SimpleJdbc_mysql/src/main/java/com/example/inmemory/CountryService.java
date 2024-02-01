package com.example.inmemory;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;
	
	public void saveCountry(Country country) throws IOException {
		countryRepository.saveCountry(country);
	}
	
	public void getCountry(String name) {
		System.out.println(countryRepository.getCountry(name).toString());
	}
	
}
