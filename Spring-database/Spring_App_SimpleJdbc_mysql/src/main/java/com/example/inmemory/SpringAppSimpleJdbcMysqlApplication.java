package com.example.inmemory;

import java.io.IOException;
import java.nio.file.Files;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.ResourceUtils;

@SpringBootApplication
public class SpringAppSimpleJdbcMysqlApplication {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new  AnnotationConfigApplicationContext(AppConfig.class);
		
		CultureService cultureService = context.getBean("cultureService",CultureService.class);
//		cultureService.saveCulture(new Culture( "India","Hinduism","Sanskrit","Bhagvadgeeta"));
//		cultureService.saveCulture(new Culture( "mauritius","Hindu","Creole","null"));
//		cultureService.saveCulture(new Culture( "Nepal","Hinduism","Nepali","Vedas"));
//		cultureService.saveCulture(new Culture( "Thailand","Buddhism","Thai","Ramayana"));
//		cultureService.saveCulture(new Culture( "UK","Christinity","English","Bible"));
//		cultureService.saveCulture(new Culture( "USA","Christinity","English","Bible"));
//	
//		cultureService.findAllCultures();
		
		Culture culture = cultureService.getCultureByName("India");
		System.out.println(culture.toString());
		
		CountryService crepos = context.getBean("countryService",CountryService.class);
		try {
			Country country = new Country();
			country.setName("Thailand");
			country.setFlag( Files.readAllBytes(ResourceUtils.getFile("classpath:thai.jpg").toPath()) );
			country.setConstitution_title("We Believe in Secularism");
			crepos.saveCountry(country);
			
			country = new Country();
			country.setName("India");
			country.setFlag( Files.readAllBytes(ResourceUtils.getFile("classpath:tiranga.jpg").toPath()) );
			country.setConstitution_title("India that is Bharat , Bharat That is India...");
			crepos.saveCountry(country);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		crepos.getCountry("India");
		context.close();
	}

}
