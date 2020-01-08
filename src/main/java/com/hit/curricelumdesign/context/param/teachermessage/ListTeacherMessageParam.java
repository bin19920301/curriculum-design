package com.hit.curricelumdesign.context.param.teachermessage;

import com.hit.curricelumdesign.context.param.BaseListRequestParam;

import javax.validation.constraints.NotNull;

/**
 * @author xbr
 * @Date 2020-01-08
 * @ClassName ListTeacherMessageParam
 * @Description
 */
public class ListTeacherMessageParam extends BaseListRequestParam {

    /**
     * 最早的消息id
     */
    private Integer earlyMsgId;

    public Integer getEarlyMsgId() {
        return earlyMsgId;
    }

    public void setEarlyMsgId(Integer earlyMsgId) {
        this.earlyMsgId = earlyMsgId;
    }

    @Override
    public String toString() {
        return "ListTeacherMessageParam{" +
                "earlyMsgId=" + earlyMsgId +
                '}';
    }
}
