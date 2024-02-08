package com.elearning.config;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.learning")
public class ElearningConfig {

    @Bean
    public Faker faker(){
        return new Faker();
    }

}
