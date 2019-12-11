package com.hit.curricelumdesign.controller;

import com.hit.curricelumdesign.context.annotation.HitApi;
import com.hit.curricelumdesign.context.param.BaseListRequestParam;
import com.hit.curricelumdesign.context.param.folder.AddFolderParam;
import com.hit.curricelumdesign.context.param.folder.DeleteFolderParam;
import com.hit.curricelumdesign.context.param.folder.GetFolderParam;
import com.hit.curricelumdesign.context.param.folder.UpdateFolderParam;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FolderController {
    @Autowired
    private FolderService folderService;

    @RequestMapping(value = "/folder/getfolderbyid/", method = RequestMethod.POST)

    public Result getFolderById(GetFolderParam folderParam) {
        return folderService.getFolderById(folderParam);
    }

    @RequestMapping(value = "/folder/addfolder/", method = RequestMethod.POST)
    @HitApi(checkAdminLogin = true)
    public Result addFolder(AddFolderParam folderParam) {
        return  folderService.addFolder(folderParam);
    }

    @RequestMapping(value = "/folder/updatefolder/", method = RequestMethod.POST)
    @HitApi(checkAdminLogin = true)
    public Result updateFolder(UpdateFolderParam folderParam) {
        return folderService.updateFolder(folderParam);
    }

    @RequestMapping(value = "/folder/deletefolder/", method = RequestMethod.POST)
    @HitApi(checkAdminLogin = true)
    public Result deleteFolder(DeleteFolderParam folderParam) {
        return folderService.deleteFolder(folderParam);
    }

    @RequestMapping(value = "/folder/listfolder/", method = RequestMethod.POST)
    @HitApi(checkAdminLogin = true)
    public Result listFolder(BaseListRequestParam folderParam) {
        return folderService.getFolderList(folderParam);
    }

    @RequestMapping(value = "/folder/getallfolder/", method = RequestMethod.POST)
    @HitApi(checkAdminLogin = true)
    public Result getAllFloder() {
        return folderService.getAllFolder();
    }
}
