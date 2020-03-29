package com.hit.curricelumdesign.context.param.workmessage;

import javax.validation.constraints.NotNull;

public class GetLastTeacherMessageParam {

    @NotNull
    private Integer lastId;

    public Integer getLastId() {
        return lastId;
    }

    public void setLastId(Integer lastId) {
        this.lastId = lastId;
    }
}
