package com.hit.curricelumdesign.manager.folder;

import com.hit.curricelumdesign.dao.FolderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FolderManager {

    @Autowired
    private FolderMapper folderMapper;
}
