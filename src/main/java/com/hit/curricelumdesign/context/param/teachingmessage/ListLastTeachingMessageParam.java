package com.hit.curricelumdesign.context.param.teachingmessage;

import com.hit.curricelumdesign.context.param.BaseRequestParam;

import javax.validation.constraints.NotNull;

public class ListLastTeachingMessageParam  extends BaseRequestParam {

    @NotNull
    private Integer lastId;

    @NotNull
    private Integer teachingId;

    public Integer getLastId() {
        return lastId;
    }

    public void setLastId(Integer lastId) {
        this.lastId = lastId;
    }

    public Integer getTeachingId() {
        return teachingId;
    }

    public void setTeachingId(Integer teachingId) {
        this.teachingId = teachingId;
    }

    @Override
    public String toString() {
        return "ListLastTeachingMessageParam{" +
                "lastId=" + lastId +
                ", teachingId=" + teachingId +
                '}';
    }
}
