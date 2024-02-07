package com.elearning.repositorytests;

import com.elearning.entities.Author;
import com.elearning.repositories.AuthorRepository;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AuthorRepositoryTests {

    private AuthorRepository authorRepository;

    private Faker faker;

    //constructor injection
    @Autowired
    AuthorRepositoryTests(AuthorRepository authorRepository){
        this.authorRepository=authorRepository;
        faker = new Faker();
    }

    @Test
    public void insertAuthorTest(){
        Author author = Author.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .age(faker.number().numberBetween(18,80))
                .email(faker.name().username().concat("@gmail.com"))
                .build();
        authorRepository.save(author);

        Optional<Author> result = authorRepository.findById(author.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(author);
    }

}
