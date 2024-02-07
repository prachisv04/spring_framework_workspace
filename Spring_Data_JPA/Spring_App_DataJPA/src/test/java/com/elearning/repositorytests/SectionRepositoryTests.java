package com.elearning.repositorytests;

import com.elearning.entities.Resource;
import com.elearning.entities.Section;
import com.elearning.repositories.ResourceRepository;
import com.elearning.repositories.SectionRepository;
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
public class SectionRepositoryTests {
    private SectionRepository sectionRepository;
    private Faker faker;

    @Autowired
    SectionRepositoryTests(SectionRepository sectionRepository){
        this.sectionRepository=sectionRepository;
        faker = new Faker();
    }

    @Test
    public void insertSectionTest(){

        Section section = Section.builder()
                .name(faker.name().username())
                .sectionOrder(faker.number().numberBetween(10000,99999))
                .build();
        sectionRepository.save(section);
        Optional<Section> sec = sectionRepository.findById(section.getId());
        assertThat(sec).isPresent();
        assertThat(sec.get()).isEqualTo(section);
    }

}
