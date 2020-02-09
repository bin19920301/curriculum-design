package com.hit.curricelumdesign.controller;

import com.hit.curricelumdesign.context.annotation.HitApi;
import com.hit.curricelumdesign.context.param.ProcessFile.AddProcessFileParam;
import com.hit.curricelumdesign.context.param.ProcessFile.ProcessFileBaseParam;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.service.ProcessFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProcessFileController {

    @Autowired
    private ProcessFileService processFileService;

    @RequestMapping(value = "/processfile/addworkfile/", method = RequestMethod.POST)
    @HitApi(checkStudentLogin = true)
    public Result addFile(AddProcessFileParam param) {
        System.out.println("进入到文件上传接口");
        return processFileService.addFile(param);
    }

    @RequestMapping(value = "/processfile/deletewrokfile/", method = RequestMethod.POST)
    @HitApi(checkStudentLogin = true)
    public Result deleteFile(ProcessFileBaseParam param) {
        return processFileService.deleteFile(param);
    }
}
