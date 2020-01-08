package com.hit.curricelumdesign.context.param.workmessage;

import com.hit.curricelumdesign.context.param.BaseListRequestParam;

import javax.validation.constraints.NotNull;

/**
 * @author xbr
 * @Date 2020-01-08
 * @ClassName WorkMessageListParam
 * @Description
 */
public class WorkMessageListParam extends BaseListRequestParam {

    /**
     * 作业id
     */
    @NotNull
    private Integer workId;

    /**
     * 最早的消息id
     */
    private Integer earlyMsgId;

    public Integer getWorkId() {
        return workId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
    }

    public Integer getEarlyMsgId() {
        return earlyMsgId;
    }

    public void setEarlyMsgId(Integer earlyMsgId) {
        this.earlyMsgId = earlyMsgId;
    }

    @Override
    public String toString() {
        return "WorkMessageListParam{" +
                "workId=" + workId +
                ", earlyMsgId=" + earlyMsgId +
                '}';
    }
}
