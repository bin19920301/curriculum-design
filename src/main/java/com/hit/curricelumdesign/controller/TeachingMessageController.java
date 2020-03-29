package com.hit.curricelumdesign.controller;

import com.hit.curricelumdesign.context.annotation.HitApi;
import com.hit.curricelumdesign.context.param.teachermessage.ListLastTeacherMessageParam;
import com.hit.curricelumdesign.context.param.teachingmessage.AddTeachingMessageParam;
import com.hit.curricelumdesign.context.param.teachingmessage.ListByTeachingIdParam;
import com.hit.curricelumdesign.context.param.teachingmessage.TeachingMessageBaseParam;
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
    @HitApi(checkTeacherLogin = true)
    public Result addTeacherMessage(AddTeachingMessageParam param) {
        return teachingMessageService.addTeacherMessage(param);
    }

    @RequestMapping(value = "/teachingmessage/addstudentmessage/", method = RequestMethod.POST)
    @HitApi(checkStudentLogin = true)
    public Result addStudentMessage(AddTeachingMessageParam param) {
        return teachingMessageService.addStudentMessage(param);
    }

    @RequestMapping(value = "/teachingmessage/deleteteachermessage/", method = RequestMethod.POST)
    @HitApi(checkTeacherLogin = true)
    public Result deleteTeacherMessage(TeachingMessageBaseParam param) {
        return teachingMessageService.deleteTeacherMessage(param);
    }

    @RequestMapping(value = "/teachingmessage/deletestudentmessage/", method = RequestMethod.POST)
    @HitApi(checkStudentLogin = true)
    public Result deleteStudentMessage(TeachingMessageBaseParam param) {
        return teachingMessageService.deleteStudentMessage(param);
    }

    @RequestMapping(value = "/teachingmessage/teacherlistbyteachindid/", method = RequestMethod.POST)
    @HitApi(checkTeacherLogin = true)
    public Result teacherListTeachingMessageByTeachingId(ListByTeachingIdParam param) {
        return teachingMessageService.teacherListTeachingMessageByTeachingId(param);
    }

    @RequestMapping(value = "/teachingmessage/studentlistbyteachindid/", method = RequestMethod.POST)
    @HitApi(checkStudentLogin = true)
    public Result studentListTeachingMessageByTeachingId(ListByTeachingIdParam param) {
        return teachingMessageService.studentListTeachingMessageByTeachingId(param);
    }

    @RequestMapping(value = "/teachingmessage/studentlistlsatbyteachindid/", method = RequestMethod.POST)
    @HitApi(checkStudentLogin = true)
    public Result studentListLastTeachingMessageByTeachingId(ListLastTeacherMessageParam param) {
        return teachingMessageService.studentListLastTeachingMessageByTeachingId(param);
    }

    @RequestMapping(value = "/teachingmessage/teacherlistlastbyteachindid/", method = RequestMethod.POST)
    @HitApi(checkTeacherLogin = true)
    public Result teacherListLastTeachingMessageByTeachingId(ListLastTeacherMessageParam param) {
        return teachingMessageService.teacherListLastTeachingMessageByTeachingId(param);
    }
}
