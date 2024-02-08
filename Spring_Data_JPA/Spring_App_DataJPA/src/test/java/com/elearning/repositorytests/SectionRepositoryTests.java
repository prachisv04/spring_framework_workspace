package com.elearning.repositorytests;
import com.elearning.entities.Lecture;
import com.elearning.entities.Section;
import com.elearning.repositories.SectionRepository;
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
public class SectionRepositoryTests {

    private   SectionRepository sectionRepository;
    private     Faker faker;

    @Autowired
    SectionRepositoryTests(SectionRepository sectionRepository){
        this.sectionRepository=sectionRepository;
        this.faker = new Faker();
    }

    @BeforeEach
    public  void init(){
        System.out.println("Before All init() method called - SectionRepository");

        for(int i=0;i<5;i++){
            Section section = Section.builder()
                    .name(faker.name().username())
                    .sectionOrder(faker.number().numberBetween(10000,99999))
                    .build();
            sectionRepository.save(section);
            System.out.println(section);
        }
    }

//    @Test
    public void insertSectionTest(){
        List<Lecture> lectures = new ArrayList<Lecture>();
        Section section = Section.builder()
                .name(faker.name().username())
                .sectionOrder(faker.number().numberBetween(10000,99999))
                .lectures(lectures)
                .course(null)
                .resource(null)
                .build();

        sectionRepository.save(section);
        Optional<Section> sec = sectionRepository.findById(section.getId());
        assertThat(sec).isPresent();
        assertThat(sec.get().getId()).isEqualTo(section.getId());
    }
    @Test
    public void findAllAuthors(){
        List<Section> sectionsList = sectionRepository.findAll();
        long total= sectionRepository.count();
        System.out.println(total);
        assertThat(sectionsList.size()).isEqualTo(total);
    }
}
