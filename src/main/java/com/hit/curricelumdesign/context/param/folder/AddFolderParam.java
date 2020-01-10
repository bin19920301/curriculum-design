package com.hit.curricelumdesign.context.param.folder;

import com.hit.curricelumdesign.context.param.BaseRequestParam;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AddFolderParam extends BaseRequestParam {
    /**
     * 文件夹名称
     */
    @NotNull
    @Size(min = 0, max = 30, message = "文件夹名称")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AddFolderParam{" +
                "name='" + name + '\'' +
                '}';
    }
}
