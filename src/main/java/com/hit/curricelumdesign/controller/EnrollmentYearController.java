package com.hit.curricelumdesign.controller;

import com.hit.curricelumdesign.context.annotation.HitApi;
import com.hit.curricelumdesign.context.param.BaseListRequestParam;
import com.hit.curricelumdesign.context.param.enrollmentyear.AddEnrollmentYearParam;
import com.hit.curricelumdesign.context.param.enrollmentyear.EnrollmentYearBaseParam;
import com.hit.curricelumdesign.context.param.enrollmentyear.UpdateEnrollmentYearParam;
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

    @RequestMapping(value = "/enrollmentyear/updateenrollmentyear/", method = RequestMethod.POST)
    @HitApi(checkAdminLogin = true)
    public Result updateEnrollmentyear(UpdateEnrollmentYearParam enrollmentyearParam) {
        return enrollmentYearService.updateEnrollmentYear(enrollmentyearParam);
    }

    @RequestMapping(value = "/enrollmentyear/deleteenrollmentyear/", method = RequestMethod.POST)
    @HitApi(checkAdminLogin = true)
    public Result deleteEnrollmentyear(EnrollmentYearBaseParam enrollmentyearParam) {
        return enrollmentYearService.deleteEnrollmentYear(enrollmentyearParam);
    }

    @RequestMapping(value = "/enrollmentyear/getenrollmentyearbyid/", method = RequestMethod.POST)
    @HitApi(checkAdminLogin = true)
    public Result getEnrollmentyearById(EnrollmentYearBaseParam enrollmentyearParam) {
        return enrollmentYearService.getEnrollmentYearById(enrollmentyearParam);
    }

    @RequestMapping(value = "/enrollmentyear/listenrollmentyear/", method = RequestMethod.POST)
    @HitApi(checkAdminLogin = true)
    public Result listEnrollmentyear(BaseListRequestParam enrollmentyearParam) {
        return enrollmentYearService.getEnrollmentYearList(enrollmentyearParam);
    }

    @RequestMapping(value = "/enrollmentyear/listallenrollmentyear/", method = RequestMethod.POST)
    @HitApi(checkAdminLogin = true)
    public Result listEnrollmentyearByParams() {
        return enrollmentYearService.getAllEnrollmentYear();
    }
}
