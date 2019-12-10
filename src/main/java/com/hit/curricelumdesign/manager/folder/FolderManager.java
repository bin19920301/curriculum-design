package com.hit.curricelumdesign.manager.folder;

import com.hit.curricelumdesign.context.dto.folder.FolderDTO;
import com.hit.curricelumdesign.context.enums.Error;
import com.hit.curricelumdesign.context.exception.BaseException;
import com.hit.curricelumdesign.dao.FolderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FolderManager {

    @Autowired
    private FolderMapper folderMapper;

    public FolderDTO getFolderById(Integer id){
        FolderDTO folderDTO = folderMapper.selectById(id);
        if (null == folderDTO){
            throw new BaseException(Error.STUDENT_IS_NOT_EXIST);
        }
        return folderDTO;
    }
}
