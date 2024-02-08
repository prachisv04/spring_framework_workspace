package com.elearning.controllers;

import com.elearning.services.LectureService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LectureController {

    @Autowired
    private LectureService lectureService;
    @Autowired
    private Faker faker;
}
