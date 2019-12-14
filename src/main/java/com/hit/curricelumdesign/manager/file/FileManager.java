package com.hit.curricelumdesign.manager.file;

import com.hit.curricelumdesign.context.entity.File;
import com.hit.curricelumdesign.dao.FileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FileManager {

    @Autowired
    private FileMapper fileMapper;

    public List<File> getFileByIdList(List<Integer> fileIdList) {
        return fileMapper.getFileByIdList(fileIdList);
    }

}
