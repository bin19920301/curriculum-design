package com.hit.curricelumdesign.controller;

import com.hit.curricelumdesign.service.TeachingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeachingController {

    @Autowired
    private TeachingService teachingService;
}
