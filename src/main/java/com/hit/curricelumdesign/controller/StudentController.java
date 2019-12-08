package com.hit.curricelumdesign.controller;

import com.hit.curricelumdesign.context.annotation.HitApi;
import com.hit.curricelumdesign.context.param.student.GetStudentParam;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/student")
public class StudentController {
/*    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/getstudentbyid", method = RequestMethod.POST)
    @HitApi(checkAdminLogin = true)
    public Result getStudentById(GetStudentParam studentParam) {
        return studentService.getAdminById(studentParam);
    }*/
}
