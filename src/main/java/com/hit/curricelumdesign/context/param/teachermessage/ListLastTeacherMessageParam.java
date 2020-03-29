package com.hit.curricelumdesign.context.param.teachermessage;

import com.hit.curricelumdesign.context.param.BaseRequestParam;

import javax.validation.constraints.NotNull;

public class ListLastTeacherMessageParam extends BaseRequestParam {

    @NotNull
    private Integer lastId;

    public Integer getLastId() {
        return lastId;
    }

    public void setLastId(Integer lastId) {
        this.lastId = lastId;
    }
}
