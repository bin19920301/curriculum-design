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
     * 起始id
     */
    private Integer startId;

    public Integer getWorkId() {
        return workId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
    }

    public Integer getStartId() {
        return startId;
    }

    public void setStartId(Integer startId) {
        this.startId = startId;
    }

    @Override
    public String toString() {
        return "WorkMessageListParam{" +
                "workId=" + workId +
                ", startId=" + startId +
                '}';
    }
}
