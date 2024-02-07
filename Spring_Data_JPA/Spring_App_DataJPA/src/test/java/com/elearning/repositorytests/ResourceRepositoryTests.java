package com.elearning.repositorytests;

import com.elearning.entities.Lecture;
import com.elearning.entities.Resource;
import com.elearning.repositories.ResourceRepository;
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
public class ResourceRepositoryTests {

    private ResourceRepository resourceRepository;
    private Faker faker;

    @Autowired
    ResourceRepositoryTests(ResourceRepository resourceRepository){
        this.resourceRepository=resourceRepository;
        faker = new Faker();
    }

    @Test
    public void insertResourceTest(){

        Resource resource = Resource.builder()
                .name(faker.name().username())
                .size(faker.number().numberBetween(1,100))
                .build();
        resourceRepository.save(resource);
        Optional<Resource> res = resourceRepository.findById(resource.getId());
        assertThat(res).isPresent();
        assertThat(res.get()).isEqualTo(resource);
    }
}
