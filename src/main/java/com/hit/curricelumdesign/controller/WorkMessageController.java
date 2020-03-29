package com.hit.curricelumdesign.controller;

import com.hit.curricelumdesign.context.annotation.HitApi;
import com.hit.curricelumdesign.context.param.BaseRequestParam;
import com.hit.curricelumdesign.context.param.workmessage.*;
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
    @HitApi(checkTeacherLogin = true)
    public Result getTeacherMessage(GetTeacherMessageParam param) {
        return workMessageService.getTeacherMessage(param);
    }

    @RequestMapping(value = "/workmessage/getstudentmessage/", method = RequestMethod.POST)
    @HitApi(checkStudentLogin = true)
    public Result getStudentMessage(GetStudentMessageParam param) {
        return workMessageService.getStudentMessage(param);
    }

    @RequestMapping(value = "/workmessage/countteacherunreadmessage/", method = RequestMethod.POST)
    @HitApi(checkTeacherLogin = true)
    public Result countTeacherUnreadMessage(BaseRequestParam param) {
        return workMessageService.countTeacherUnreadMessage(param);
    }

    @RequestMapping(value = "/workmessage/countstudentunreadmessage/", method = RequestMethod.POST)
    @HitApi(checkStudentLogin = true)
    public Result countStudentUnreadMessage(BaseRequestParam param) {
        return workMessageService.countStudentUnreadMessage(param);
    }

    @RequestMapping(value = "/workmessage/deleteteahcermessage/", method = RequestMethod.POST)
    @HitApi(checkTeacherLogin = true)
    public Result deleteTeahcerMessage(WorkMessageBaseParam param) {
        return workMessageService.deleteTeahcerMessage(param);
    }

    @RequestMapping(value = "/workmessage/deletestudentmessage/", method = RequestMethod.POST)
    @HitApi(checkStudentLogin = true)
    public Result deleteStudentMessage(WorkMessageBaseParam param) {
        return workMessageService.deleteStudentMessage(param);
    }


    @RequestMapping(value = "/workmessage/teacherlistmessage/", method = RequestMethod.POST)
    @HitApi(checkTeacherLogin = true)
    public Result teacherListWorkMessage(WorkMessageListParam param) {
        return workMessageService.teacherListWorkMessage(param);
    }

    @RequestMapping(value = "/workmessage/studentlistmessage/", method = RequestMethod.POST)
    @HitApi(checkStudentLogin = true)
    public Result studentListWorkMessage(WorkMessageListParam param) {
        return workMessageService.studentListWorkMessage(param);
    }

    @RequestMapping(value = "/workmessage/studentlistlastmessage/", method = RequestMethod.POST)
    @HitApi(checkStudentLogin = true)
    public Result studentListLastWorkMessage(GetLastStudentMessageParam param) {
        return workMessageService.studentListLastMessage(param);
    }

    @RequestMapping(value = "/workmessage/teacherlistLastmessage/", method = RequestMethod.POST)
    //@HitApi(checkTeacherLogin = true)
    public Result teacherListLastWorkMessage(GetLastTeacherMessageParam param) {
        return workMessageService.teacherListLastMessage(param);
    }

}
