package com.elearning.repositorytests;

import com.elearning.entities.Lecture;
import com.elearning.repositories.LectureRepository;
import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class LectureRepositoryTests {

    private  LectureRepository lectureRepository;
    private  Faker faker;

    @Autowired
    LectureRepositoryTests(LectureRepository lectureRepository){
        this.lectureRepository = lectureRepository;
        this.faker = new Faker();
    }

    @BeforeEach
    public  void init(){
        System.out.println("Before All init() method called - LectureRepositoryTests");
        for(int i=0;i<5;i++){
            Lecture lecture = Lecture.builder()
                    .name(faker.book().title())
                    .build();

            lectureRepository.save(lecture);
        }
    }

    @Test
    public void insertLectureTest(){
        Lecture lecture = Lecture.builder()
                .name(faker.book().title())
                .build();
        lectureRepository.save(lecture);

        Optional<Lecture> lec = lectureRepository.findById(lecture.getId());
        assertThat(lec).isPresent();
        assertThat(lec.get()).isEqualTo(lecture);
    }

    @Test
    public void findAllAuthors(){
        List<Lecture> lectureList = lectureRepository.findAll();
        long total= lectureRepository.count();
        assertThat(lectureList.size()).isEqualTo(total);
    }
}
