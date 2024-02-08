package com.elearning.controllers;

import com.elearning.entities.Author;
import com.elearning.services.AuthorService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;
    @Autowired
    private Faker faker;

    public  AuthorController() {
        System.out.println("AuthorController created");
    }

    public void saveAuthor(){
        String fn = faker.name().firstName();
        String ln = faker.name().lastName();
        Author author = Author.builder()
                .firstName(fn)
                .lastName(ln)
                .age(faker.number().numberBetween(18,80))
                .email(fn+ln+"@gmail.com")
                .build();
        authorService.saveAuthor(author);
    }

}
