package com.elearning.repositorytests;

import com.elearning.entities.Author;
import com.elearning.entities.Course;
import com.elearning.repositories.AuthorRepository;
import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AuthorRepositoryTests {

    private  AuthorRepository authorRepository;

    private  Faker faker;

    //constructor injection
    @Autowired
    AuthorRepositoryTests(AuthorRepository authorRepository){
        this.authorRepository=authorRepository;
        faker=new Faker();
    }

    @BeforeEach
    public void store(){
        System.out.println("Before All init() method called - AuthorRepositoryTests");

        for(int i=0;i<5;i++){
            Author author = Author.builder()
                    .firstName(faker.name().firstName())
                    .lastName(faker.name().lastName())
                    .age(faker.number().numberBetween(18,80))
                    .email(faker.name().username().concat("@gmail.com"))
                    .build();
            authorRepository.save(author);
        }
    }

    @Test
    public void insertAuthorTest(){
        List<Course> courses =new ArrayList<>();

        Author author = Author.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .age(faker.number().numberBetween(18,80))
                .email(faker.name().username().concat("@gmail.com"))
                .courses(courses)
                .build();
        authorRepository.save(author);

        Optional<Author> result = authorRepository.findById(author.getId());
        assertThat(result).isPresent();
        assertThat(result.get().getId()).isEqualTo(author.getId());
    }

    @Test
    public void findAllAuthors(){

       List<Author> authorList = authorRepository.findAll();
       long total= authorRepository.count();
       assertThat(authorList.size()).isEqualTo(total);
    }

}
