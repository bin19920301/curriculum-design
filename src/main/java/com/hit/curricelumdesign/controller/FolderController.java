package com.hit.curricelumdesign.controller;

import com.hit.curricelumdesign.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FolderController {
    @Autowired
    private FolderService folderService;
}
