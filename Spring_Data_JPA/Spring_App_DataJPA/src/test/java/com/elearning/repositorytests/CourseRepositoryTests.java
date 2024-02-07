package com.elearning.repositorytests;

import com.elearning.entities.Course;
import com.elearning.repositories.CourseRepository;
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
public class CourseRepositoryTests {

    private CourseRepository courseRepository;
    private Faker faker;

    @Autowired
    CourseRepositoryTests(CourseRepository courseRepository){
        this.courseRepository=courseRepository;
        faker = new Faker();
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
        result.toString();
        assertThat(result.get()).isEqualTo(course);
    }

}
