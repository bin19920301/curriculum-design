package com.hit.curricelumdesign.context.param.finishedsurface;

import com.hit.curricelumdesign.context.param.BaseRequestParam;

/**
 * @author xbr
 * @Date 2020-02-23
 * @ClassName FinishedSurfaceListParam
 * @Description
 */
public class FinishedSurfaceListParam extends BaseRequestParam {

    /**
     * 作业项目id
     */
    private Integer workProjectId;

    public Integer getWorkProjectId() {
        return workProjectId;
    }

    public void setWorkProjectId(Integer workProjectId) {
        this.workProjectId = workProjectId;
    }

    @Override
    public String toString() {
        return "FinishedSurfaceListParam{" +
                "workProjectId=" + workProjectId +
                '}';
    }
}
