package com.elearning.controllers;

import com.elearning.services.SectionService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SectionController {

    @Autowired
    private SectionService sectionService;

    @Autowired
    private Faker faker;
}
