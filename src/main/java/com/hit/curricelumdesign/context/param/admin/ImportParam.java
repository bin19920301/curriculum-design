package com.hit.curricelumdesign.context.param.admin;

import com.hit.curricelumdesign.context.param.BaseRequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

public class ImportParam extends BaseRequestParam {
    /**
     * 上传的eccel文件
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
