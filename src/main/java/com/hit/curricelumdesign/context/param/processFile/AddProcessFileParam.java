package com.hit.curricelumdesign.context.param.processFile;

import com.hit.curricelumdesign.context.param.BaseRequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

public class AddProcessFileParam extends BaseRequestParam {
    /**
     * 上传文件的实体
     */
    @NotNull
    private MultipartFile file;


    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

}
