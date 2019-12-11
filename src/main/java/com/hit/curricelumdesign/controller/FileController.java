package com.hit.curricelumdesign.controller;

import com.hit.curricelumdesign.context.annotation.HitApi;
import com.hit.curricelumdesign.context.param.file.AddFileParam;
import com.hit.curricelumdesign.context.param.file.FileBaseParam;
import com.hit.curricelumdesign.context.param.file.ConditionFileParam;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class FileController {

    @Autowired
    private FileService fileService;

    @RequestMapping(value = "/file/addFile/", method = RequestMethod.POST)
    @HitApi(checkAdminLogin = true)
    public Result addFile(AddFileParam param) {
        return fileService.addFile(param);
    }

    @RequestMapping(value = "/file/downloadFile/", method = RequestMethod.POST)
    @HitApi(checkAdminLogin = true)
    public void downloadFile(FileBaseParam param, HttpServletResponse response) throws IOException {
        fileService.downloadFile(param,response);
    }

    @RequestMapping(value = "/file/deleteFile/", method = RequestMethod.POST)
    @HitApi(checkAdminLogin = true)
    public Result deleteFile(FileBaseParam param) {
        return fileService.deleteFile(param);
    }

    @RequestMapping(value = "/file/getFileByFolderId/", method = RequestMethod.POST)
    @HitApi(checkAdminLogin = true)
    public Result getFileByFolderId(ConditionFileParam param)  {
        return fileService.getFileByFolderId(param);
    }

    @RequestMapping(value = "/file/addusecount/", method = RequestMethod.POST)
    @HitApi(checkAdminLogin = true)
    public Result addFileUseCount(FileBaseParam param)  {
        return fileService.addUseCount(param);
    }
}
