package com.example.inmemory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CultureService {
	
	@Autowired
	private CultureRepository repo;
	
	CultureService(){
		System.out.println("Service Created");
	}
	
	public void saveCulture(Culture culture) {
		repo.saveCulture(culture);
	}
	
	public void findAllCultures() {
		List<Culture> cultures = repo.findAllCultures();
		cultures.forEach(culture-> System.out.println(culture.toString()));
	}
}
