package com.hit.curricelumdesign.context.param.teachingmessage;

import com.hit.curricelumdesign.context.param.BaseListRequestParam;

import javax.validation.constraints.NotNull;

public class ListByTeachingIdParam extends BaseListRequestParam {

    /**
     *
     */
    @NotNull
    private Integer teachingId;

    public Integer getTeachingId() {
        return teachingId;
    }

    public void setTeachingId(Integer teachingId) {
        this.teachingId = teachingId;
    }

    @Override
    public String toString() {
        return "ListByTeachingIdParam{" +
                "teachingId=" + teachingId +
                '}';
    }
}
