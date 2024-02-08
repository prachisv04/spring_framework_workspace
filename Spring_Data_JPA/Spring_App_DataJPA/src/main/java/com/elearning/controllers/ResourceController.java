package com.elearning.controllers;

import com.elearning.services.ResourceService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private Faker faker;
}
