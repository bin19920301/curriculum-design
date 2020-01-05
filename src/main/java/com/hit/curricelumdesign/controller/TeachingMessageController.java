package com.hit.curricelumdesign.controller;

import com.hit.curricelumdesign.context.param.teachingmessage.AddTeachingMessageParam;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.service.TeachingMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeachingMessageController {

    @Autowired
    private TeachingMessageService teachingMessageService;

    @RequestMapping(value = "/teachingmessage/addteachermessage/", method = RequestMethod.POST)
    //@HitApi(checkTeacherLogin = true)
    public Result addTeacherMessage(AddTeachingMessageParam param){
        return  teachingMessageService.addTeacherMessage(param);
    }
}
