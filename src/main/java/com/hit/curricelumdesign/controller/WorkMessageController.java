package com.hit.curricelumdesign.controller;

import com.hit.curricelumdesign.context.annotation.HitApi;
import com.hit.curricelumdesign.context.param.workmessage.AddWorkMessageByStudentParam;
import com.hit.curricelumdesign.context.param.workmessage.AddWorkMessageByTeacherParam;
import com.hit.curricelumdesign.context.param.workmessage.GetStudentMessageParam;
import com.hit.curricelumdesign.context.param.workmessage.GetTeacherMessageParam;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.dao.WorkMessageMapper;
import com.hit.curricelumdesign.service.WorkMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xbr
 * @Date 2019-12-22
 * @ClassName WorkMessageController
 * @Description
 */
@RestController
public class WorkMessageController {

    @Autowired
    private WorkMessageMapper workMessageMapper;

    @Autowired
    private WorkMessageService workMessageService;


    @RequestMapping(value = "/workmessage/addmessagebyteacher/", method = RequestMethod.POST)
    @HitApi(checkTeacherLogin = true)
    public Result addMessageByTeacher(AddWorkMessageByTeacherParam param) {
        return workMessageService.addMessageByTeacher(param);
    }

    @RequestMapping(value = "/workmessage/addmessagebystudent/", method = RequestMethod.POST)
    @HitApi(checkStudentLogin = true)
    public Result addMessageByStudent(AddWorkMessageByStudentParam param) {
        return workMessageService.addMessageByStudent(param);
    }

    @RequestMapping(value = "/workmessage/getteachermessage/", method = RequestMethod.POST)
    public Result getTeacherMessage(GetTeacherMessageParam param) {
        return workMessageService.getTeacherMessage(param);
    }

    @RequestMapping(value = "/workmessage/getstudentmessage/", method = RequestMethod.POST)
    public Result getStudentMessage(GetStudentMessageParam param) {
        return workMessageService.getStudentMessage(param);
    }
}
