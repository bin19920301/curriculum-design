package com.hit.curricelumdesign.context.param.folder;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class AddFolderParam {
    /**
     * 文件夹名称
     */
    @NotNull
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
