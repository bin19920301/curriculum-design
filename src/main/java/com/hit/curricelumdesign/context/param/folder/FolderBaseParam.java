package com.hit.curricelumdesign.context.param.folder;

import com.hit.curricelumdesign.context.param.BaseRequestParam;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotNull;

public class FolderBaseParam extends BaseRequestParam {
    /**
     * 文件夹id
     */
    @NotNull
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "FolderBaseParam{" +
                "id=" + id +
                '}';
    }
}
