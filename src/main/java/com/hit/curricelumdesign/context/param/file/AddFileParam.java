package com.hit.curricelumdesign.context.param.file;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class AddFileParam {
    /**
     * 上传文件的实体
     */
    @NotNull
    private MultipartFile file;

    /**
     * 文件夹id
     */
    @NotNull
    private Integer folderId;


    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public Integer getFolderId() {
        return folderId;
    }

    public void setFolderId(Integer folderId) {
        this.folderId = folderId;
    }

}
