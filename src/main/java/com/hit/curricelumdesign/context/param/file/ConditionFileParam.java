package com.hit.curricelumdesign.context.param.file;

import javax.persistence.criteria.CriteriaBuilder;

public class ConditionFileParam {
    /**
     * 文件夹id
     */
    private Integer folderId;

    public Integer getFolderId() {
        return folderId;
    }

    public void setFolderId(Integer folderId) {
        this.folderId = folderId;
    }
}
