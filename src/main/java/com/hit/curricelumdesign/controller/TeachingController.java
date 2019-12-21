package com.hit.curricelumdesign.controller;

import com.hit.curricelumdesign.context.annotation.HitApi;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.service.TeachingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeachingController {

    @Autowired
    private TeachingService teachingService;

    @RequestMapping(value = "/teaching/addteaching/", method = RequestMethod.POST)
    @HitApi(checkAdminLogin = true)
    public Result addTeaching(){
        return Result.success();
    }

    @RequestMapping(value = "/teaching/updateteaching/", method = RequestMethod.POST)
    @HitApi(checkAdminLogin = true)
    public Result updateTeaching(){
        return Result.success();
    }
}
