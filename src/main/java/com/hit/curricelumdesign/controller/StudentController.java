package com.hit.curricelumdesign.controller;

import com.hit.curricelumdesign.context.annotation.HitApi;
import com.hit.curricelumdesign.context.param.BaseListRequestParam;
import com.hit.curricelumdesign.context.param.student.*;
import com.hit.curricelumdesign.context.param.teacher.*;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/student/getstudentbyid/", method = RequestMethod.POST)

    public Result getStudentById(GetStudentParam studentParam) {
        return studentService.getStudentById(studentParam);
    }

    @RequestMapping(value = "/student/addstudent/", method = RequestMethod.POST)
    @HitApi(checkAdminLogin = true)
    public Result addStudent(AddStudentParam studentParam) {
        return  studentService.addStudent(studentParam);
    }

    @RequestMapping(value = "/student/updatestudent/", method = RequestMethod.POST)
    @HitApi(checkAdminLogin = true)
    public Result updateStudent(UpdateStudentParam studentParam) {
        return studentService.updateStudent(studentParam);
    }

    @RequestMapping(value = "/student/deletestudent/", method = RequestMethod.POST)
    @HitApi(checkAdminLogin = true)
    public Result deleteStudent(DeleteStudentParam studentParam) {
        return studentService.deleteStudent(studentParam);
    }

    @RequestMapping(value = "/student/liststudent/", method = RequestMethod.POST)
    @HitApi(checkAdminLogin = true)
    public Result listStudent(BaseListRequestParam studentParam) {
        return studentService.getStudentList(studentParam);
    }

    @RequestMapping(value = "/student/liststudentbyparam/", method = RequestMethod.POST)
    @HitApi(checkAdminLogin = true)
    public Result listStudentByParams(ConditionSearchStudentParam studentParam) {
        return studentService.getStudentByParams(studentParam);
    }
}
