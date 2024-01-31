package com.example.inmemory;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringAppSimpleJdbcMysqlApplication {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new  AnnotationConfigApplicationContext(AppConfig.class);
		
		CultureService cultureService = context.getBean("cultureService",CultureService.class);
		cultureService.saveCulture(new Culture( "mauritius","Hindu","Creole","null"));
		cultureService.saveCulture(new Culture( "Thailand","Buddhism","Thai","Ramayana"));
		cultureService.findAllCultures();
		
		context.close();
	}

}
