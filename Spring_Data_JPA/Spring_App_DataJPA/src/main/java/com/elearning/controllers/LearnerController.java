package com.elearning.controllers;

import com.elearning.services.AuthorService;
import com.elearning.services.LearnerService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LearnerController {

    @Autowired
    private LearnerService learnerService;
    @Autowired
    private Faker faker;
}
