package com.hit.curricelumdesign.controller;

import com.hit.curricelumdesign.context.annotation.HitApi;
import com.hit.curricelumdesign.context.param.BaseListRequestParam;
import com.hit.curricelumdesign.context.param.teachermessage.AddTeacherMessageParam;
import com.hit.curricelumdesign.context.param.teachermessage.ListLastTeacherMessageParam;
import com.hit.curricelumdesign.context.param.teachermessage.ListTeacherMessageParam;
import com.hit.curricelumdesign.context.param.teachermessage.TeacherMessageBaseParam;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.service.TeacherMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherMessageController {

    @Autowired
    private TeacherMessageService teacherMessageService;

    @RequestMapping(value = "/teachermessage/addmessage/", method = RequestMethod.POST)
    @HitApi(checkTeacherLogin = true)
    public Result addTeacherMessage(AddTeacherMessageParam param){
        return  teacherMessageService.addTeacherMessage(param);
    }

    @RequestMapping(value = "/teachermessage/deletemessage/", method = RequestMethod.POST)
    @HitApi(checkTeacherLogin = true)
    public Result deleteTeacherMessage(TeacherMessageBaseParam param){
        return  teacherMessageService.deleteTeacherMessage(param);
    }

    @RequestMapping(value = "/teachermessage/listmessage/", method = RequestMethod.POST)
    @HitApi(checkTeacherLogin = true)
    public Result listTeacherMessage(ListTeacherMessageParam param){
        return  teacherMessageService.listTeacherMessage(param);
    }

    @RequestMapping(value = "/teachermessage/listlastteachermessage/", method = RequestMethod.POST)
    @HitApi(checkTeacherLogin = true)
    public Result listLastTeacherMessage(ListLastTeacherMessageParam param){
        return  teacherMessageService.listLastTeacherMessage(param);
    }
}
