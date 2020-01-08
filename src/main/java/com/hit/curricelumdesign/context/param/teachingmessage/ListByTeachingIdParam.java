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
     * 最早的消息id
     */
    private Integer earlyMsgId;

    public Integer getTeachingId() {
        return teachingId;
    }

    public void setTeachingId(Integer teachingId) {
        this.teachingId = teachingId;
    }

    public Integer getEarlyMsgId() {
        return earlyMsgId;
    }

    public void setEarlyMsgId(Integer earlyMsgId) {
        this.earlyMsgId = earlyMsgId;
    }

    @Override
    public String toString() {
        return "ListByTeachingIdParam{" +
                "teachingId=" + teachingId +
                ", earlyMsgId=" + earlyMsgId +
                '}';
    }
}
