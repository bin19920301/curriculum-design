package com.hit.curricelumdesign.context.param.workfile;

import com.hit.curricelumdesign.context.param.BaseRequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

public class AddWorkFileParam extends BaseRequestParam {
    /**
     * 上传文件的实体
     */
    @NotNull
    private MultipartFile file;

    /**
     * 作业id
     */
    @NotNull
    private Integer workId;


    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public Integer getWorkId() {
        return workId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
    }
}
