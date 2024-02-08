package com.elearning;

import com.elearning.controllers.AuthorController;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAppDataJpaApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(SpringAppDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
