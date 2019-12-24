package com.hit.curricelumdesign.controller;

import com.hit.curricelumdesign.context.annotation.HitApi;
import com.hit.curricelumdesign.context.entity.WorkProject;
import com.hit.curricelumdesign.context.param.clazz.AddClassParam;
import com.hit.curricelumdesign.context.param.workproject.*;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.service.WorkProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xbr
 * @Date 2019-12-12
 * @ClassName WorkProjectController
 * @Description
 */
@RestController
public class WorkProjectController {

    @Autowired
    private WorkProjectService workProjectService;

    @RequestMapping(value = "/workproject/addworkproject/", method = RequestMethod.POST)
    @HitApi(checkTeacherLogin = true)
    public Result addWorkProject(AddWorkProjectParam param) {
        return workProjectService.addWorkProject(param);
    }

    @RequestMapping(value = "/workproject/getworkprojectlist/", method = RequestMethod.POST)
    public Result getWorkProjectList(GetWorkProjectListParam param) {
        return workProjectService.getWorkProjectList(param);
    }

    @RequestMapping(value = "/workproject/getallworkprojectlist/", method = RequestMethod.POST)
    public Result getAllWorkProjectList() {
        return workProjectService.getAllWorkProjectList();
    }


    @RequestMapping(value = "/workproject/getworkprojectinfo/", method = RequestMethod.POST)
    public Result getWorkProjectInfo(GetWorkProjectInfoParam param) {
        return workProjectService.getWorkProjectInfo(param);
    }

    @RequestMapping(value = "/workproject/updateworkproject/", method = RequestMethod.POST)
    @HitApi(checkTeacherLogin = true)
    public Result updateWorkProject(UpdateWorkProjectParam param) {
        return workProjectService.updateWorkProject(param);
    }

    @RequestMapping(value = "/workproject/deleteworkproject/", method = RequestMethod.POST)
    @HitApi(checkTeacherLogin = true)
    public Result deleteWorkProject(DeleteWorkProjectParam param) {
        return workProjectService.deleteWorkProject(param);
    }

}
