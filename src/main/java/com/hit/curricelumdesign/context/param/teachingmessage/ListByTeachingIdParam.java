package com.hit.curricelumdesign.context.param.teachingmessage;

import com.hit.curricelumdesign.context.param.BaseListRequestParam;

import javax.validation.constraints.NotNull;

public class ListByTeachingIdParam extends BaseListRequestParam {

    /**
     * 教学
     */
    @NotNull
    private Integer teachingId;

    /**
     * 起始id
     */
    private Integer startId;

    public Integer getTeachingId() {
        return teachingId;
    }

    public void setTeachingId(Integer teachingId) {
        this.teachingId = teachingId;
    }

    public Integer getStartId() {
        return startId;
    }

    public void setStartId(Integer startId) {
        this.startId = startId;
    }

    @Override
    public String toString() {
        return "ListByTeachingIdParam{" +
                "teachingId=" + teachingId +
                ", startId=" + startId +
                '}';
    }
}
