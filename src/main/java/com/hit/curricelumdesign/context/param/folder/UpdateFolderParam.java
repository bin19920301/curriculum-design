package com.hit.curricelumdesign.context.param.folder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateFolderParam extends FolderBaseParam {
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
        return "UpdateFolderParam{" +
                "name='" + name + '\'' +
                '}';
    }
}
