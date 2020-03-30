package com.hit.curricelumdesign.context.param.workmessage;

import com.hit.curricelumdesign.context.param.BaseRequestParam;

import javax.validation.constraints.NotNull;

public class GetLastTeacherMessageParam extends BaseRequestParam {

    @NotNull
    private Integer lastId;

    @NotNull
    private Integer workId;

    public Integer getLastId() {
        return lastId;
    }

    public void setLastId(Integer lastId) {
        this.lastId = lastId;
    }

    public Integer getWorkId() {
        return workId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
    }

    @Override
    public String toString() {
        return "GetLastTeacherMessageParam{" +
                "lastId=" + lastId +
                ", workId=" + workId +
                '}';
    }
}
