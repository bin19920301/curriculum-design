package com.hit.curricelumdesign.controller;

import com.hit.curricelumdesign.context.annotation.HitApi;
import com.hit.curricelumdesign.context.param.workfile.AddWorkFileParam;
import com.hit.curricelumdesign.context.param.workfile.WorkFileBaseParam;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.service.WorkFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkFileController {

    @Autowired
    private WorkFileService workFileService;

    @RequestMapping(value = "/workfile/addworkfile/", method = RequestMethod.POST)
    @HitApi(checkStudentLogin = true)
    public Result addFile(AddWorkFileParam param) {
        return workFileService.addFile(param);
    }

    @RequestMapping(value = "/workfile/deletewrokfile/", method = RequestMethod.POST)
    @HitApi(checkStudentLogin = true)
    public Result deleteFile(WorkFileBaseParam param) {
        return workFileService.deleteFile(param);
    }
}
