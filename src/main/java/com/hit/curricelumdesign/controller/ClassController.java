package com.hit.curricelumdesign.controller;

import com.hit.curricelumdesign.context.annotation.HitApi;
import com.hit.curricelumdesign.context.param.clazz.AddClassParam;
import com.hit.curricelumdesign.context.param.clazz.DeleteClassParam;
import com.hit.curricelumdesign.context.param.clazz.GetClassByAcademyIdParam;
import com.hit.curricelumdesign.context.param.clazz.RenameClassParam;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xbr
 * @Date 2019-12-09
 * @ClassName ClassController
 * @Description
 */
@RestController
public class ClassController {

    @Autowired
    private ClassService classService;


    @RequestMapping(value = "/class/addclass/", method = RequestMethod.POST)
    @HitApi(checkAdminLogin = true)
    public Result addClass(AddClassParam param) {
        return classService.addClass(param);
    }


    @RequestMapping(value = "/class/renameclass/", method = RequestMethod.POST)
    @HitApi(checkAdminLogin = true)
    public Result renameClass(RenameClassParam param) {
        return classService.renameClass(param);
    }


    @RequestMapping(value = "/class/deleteclass/", method = RequestMethod.POST)
    @HitApi(checkAdminLogin = true)
    public Result deleteClass(DeleteClassParam param) {
        return classService.deleteClass(param);
    }
    @RequestMapping(value = "/class/getclassbyacademyid/", method = RequestMethod.POST)
    public Result getClassByAcademyId(GetClassByAcademyIdParam param) {
        return classService.getClassByAcademyId(param);
    }
}
