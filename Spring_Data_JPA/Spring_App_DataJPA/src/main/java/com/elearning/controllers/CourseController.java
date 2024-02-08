package com.elearning.controllers;

import com.elearning.services.CourseService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private Faker faker ;
}
