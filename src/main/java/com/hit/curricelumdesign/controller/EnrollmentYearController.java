package com.hit.curricelumdesign.controller;

import com.hit.curricelumdesign.context.annotation.HitApi;
import com.hit.curricelumdesign.context.param.clazz.AddClassParam;
import com.hit.curricelumdesign.context.param.enrollmentyear.AddEnrollmentYearParam;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.service.EnrollmentYearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xbr
 * @Date 2019-12-09
 * @ClassName EnrollmentYearController
 * @Description
 */
@RestController
public class EnrollmentYearController {


    @Autowired
    private EnrollmentYearService enrollmentYearService;

    @RequestMapping(value = "/enrollmentyear/addenrollmentyear/", method = RequestMethod.POST)
    @HitApi(checkAdminLogin = true)
    public Result addEnrollmentYear(AddEnrollmentYearParam param) {
        return enrollmentYearService.addEnrollmentYear(param);
    }

}
