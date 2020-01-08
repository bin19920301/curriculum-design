package com.hit.curricelumdesign.controller;

import com.hit.curricelumdesign.context.annotation.HitApi;
import com.hit.curricelumdesign.context.param.BaseListRequestParam;
import com.hit.curricelumdesign.context.param.academy.AddAcademyParam;
import com.hit.curricelumdesign.context.param.academy.DeleteAcademyParam;
import com.hit.curricelumdesign.context.param.academy.RenameAcademyParam;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.service.AcademyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xbr
 * @Date 2019-12-08
 * @ClassName AcademyController
 * @Description
 */
@RestController
public class AcademyController {

    @Autowired
    private AcademyService academyService;

    @RequestMapping(value = "/academy/addacademy/", method = RequestMethod.POST)
    @HitApi(checkAdminLogin = true)
    public Result addAcademy(AddAcademyParam param) {
        return academyService.addAcademy(param);
    }

    @RequestMapping(value = "/academy/renameacademy/", method = RequestMethod.POST)
    @HitApi(checkAdminLogin = true)
    public Result renameAcademy(RenameAcademyParam param) {
        return academyService.renameAcademy(param);
    }

    @RequestMapping(value = "/academy/getacademylist/", method = RequestMethod.POST)
    public Result getAcademyList(BaseListRequestParam param) {
        return academyService.getAcademyList(param);
    }

    @RequestMapping(value = "/academy/getallacademylist/", method = RequestMethod.POST)
    public Result getAllAcademyList() {
        return academyService.getAllAcademyList();
    }

    @RequestMapping(value = "/academy/deleteacademy/", method = RequestMethod.POST)
    @HitApi(checkAdminLogin = true)
    public Result deleteAcademy(DeleteAcademyParam param) {
        return academyService.deleteAcademy(param);
    }


}
