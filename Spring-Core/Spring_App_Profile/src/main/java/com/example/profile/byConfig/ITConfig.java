package com.example.profile.byConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("it")
public class ITConfig {

	@Bean("itBean")

	IT getITBean() {
		return new IT();
	}
	
}
