package com.example.profile.byConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("hr")
public class HRConfig {
	
	@Bean("hrBean")
	 HR getHRBean() {
		return new HR();
	}

}
