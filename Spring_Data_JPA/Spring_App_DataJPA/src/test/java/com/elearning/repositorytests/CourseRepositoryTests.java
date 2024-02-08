package com.elearning.repositorytests;

import com.elearning.entities.Course;
import com.elearning.repositories.CourseRepository;
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
public class CourseRepositoryTests {

    private  CourseRepository courseRepository;
    private  Faker faker;

    @Autowired
    CourseRepositoryTests(CourseRepository courseRepository){
        this.courseRepository=courseRepository;
        this.faker = new Faker();
    }

    @BeforeEach
    public  void init(){
        System.out.println("Before All init() method called - CourseRepositoryTests");

        for(int i=0;i<5;i++){
            String c = faker.educator().course();
            Course course = Course.builder()
                    .title(c)
                    .description(c+" have no description")
                    .build();
            courseRepository.save(course);
        }
    }

    @Test
    public void insertCourseTest(){
        String c = faker.educator().course();
        Course course = Course.builder()
                .title(c)
                .description(c+" have no description")
                .build();
        courseRepository.save(course);

        Optional<Course> result = courseRepository.findById(course.getId());
        assertThat(result).isPresent();
        System.out.println(result);
        assertThat(result.get().getId()).isEqualTo(course.getId());
    }
    @Test
    public void findAllAuthors(){
        List<Course> courseList = courseRepository.findAll();
        long total= courseRepository.count();
        assertThat(courseList.size()).isEqualTo(total);
    }
}
