package com.hit.curricelumdesign.controller;

import com.hit.curricelumdesign.context.annotation.HitApi;
import com.hit.curricelumdesign.context.param.BaseRequestParam;
import com.hit.curricelumdesign.context.param.teacher.*;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "/teacher/getteacherbyid/", method = RequestMethod.POST)
    @HitApi(checkAdminLogin = true)
    public Result getTeacherById(GetTeacherParam teacherParam) {
        return teacherService.getTeacherById(teacherParam);
    }

    @RequestMapping(value = "/teacher/addteacher/", method = RequestMethod.POST)
    @HitApi(checkAdminLogin = true)
    public Result addTeacher(AddTeacherParam teacherParam) {
        return teacherService.addTeacher(teacherParam);
    }

    @RequestMapping(value = "/teacher/updateteacher/", method = RequestMethod.POST)
    @HitApi(checkAdminLogin = true)
    public Result updateTeacher(UpdateTeacherParam teacherParam) {
        return teacherService.updateTeacher(teacherParam);
    }

    @RequestMapping(value = "/teacher/deleteteacher/", method = RequestMethod.POST)
    @HitApi(checkAdminLogin = true)
    public Result deleteTeacher(DeleteTeacherParam teacherParam) {
        return teacherService.deleteTeacher(teacherParam);
    }

    @RequestMapping(value = "/teacher/listteacher/", method = RequestMethod.POST)
    @HitApi(checkAdminLogin = true)
    public Result listTeacher(GetTeacherListParam teacherParam) {
        //这里目前还没有调用方法
        return teacherService.getTeacherList(teacherParam);
    }

    @RequestMapping(value = "/teacher/resetteacherpassword/", method = RequestMethod.POST)
    @HitApi(checkAdminLogin = true)
    public Result resetTeacherPassword(ResetPasswordParam teacherParam) {
        return teacherService.resetTeacherPassword(teacherParam);
    }

    @RequestMapping(value = "/teacher/login/", method = RequestMethod.POST)
    public Result teacherLogin(TeacherLoginParam param) {
        return teacherService.teacherLogin(param);
    }

    @RequestMapping(value = "/teacher/logout/", method = RequestMethod.POST)
    @HitApi(checkTeacherLogin = true)
    public Result teacherLogout(BaseRequestParam param) {
        return teacherService.teacherLogout(param);
    }


}
