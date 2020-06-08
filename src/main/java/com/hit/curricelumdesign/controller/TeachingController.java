package com.hit.curricelumdesign.controller;

import com.hit.curricelumdesign.context.annotation.HitApi;
import com.hit.curricelumdesign.context.entity.Teaching;
import com.hit.curricelumdesign.context.param.teaching.*;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.manager.teaching.TeachingManager;
import com.hit.curricelumdesign.service.TeachingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeachingController {

    @Autowired
    private TeachingService teachingService;

    @Autowired
    private TeachingManager teachingManager;

    @RequestMapping(value = "/teaching/addteaching/", method = RequestMethod.POST)
    @HitApi(checkTeacherLogin = true)
    public Result addTeaching(@RequestBody AddTeachingParam teachingParam) {
        teachingService.addTeaching(teachingParam);
        return Result.success();
    }

    @RequestMapping(value = "/teaching/updateteaching/", method = RequestMethod.POST)
    @HitApi(checkTeacherLogin = true)
    public Result updateTeaching(@RequestBody UpdateTeachingParam teachingParam) {
        teachingService.updateTeaching(teachingParam);
        return Result.success();
    }


    @RequestMapping(value = "/teaching/getteachingbycreatoridandstatus/", method = RequestMethod.POST)
    @HitApi(checkTeacherLogin = true)
    public Result getTeachingByCreatorId(ConditionTeachingParam teachingParam) {
        return teachingService.getTeachingByCreatorId(teachingParam);
    }

    @RequestMapping(value = "/teaching/getteachingbyId/", method = RequestMethod.POST)
    @HitApi(checkTeacherLogin = true)
    public Result getTeachingById(GetTeachingParam teachingParam) {
        return teachingService.getTeachingById(teachingParam);
    }
}
