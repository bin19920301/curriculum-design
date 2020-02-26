package com.hit.curricelumdesign.context.param.finishedsurface;

import com.hit.curricelumdesign.context.param.BaseRequestParam;

/**
 * @author xbr
 * @Date 2020-02-24
 * @ClassName DelFinishedSurfaceParam
 * @Description
 */
public class DelFinishedSurfaceParam extends BaseRequestParam {

    /**
     * 作业项目id
     */
    private Integer workProjectId;

    /**
     * 表面id
     */
    private Integer surfaceId;

    public Integer getWorkProjectId() {
        return workProjectId;
    }

    public void setWorkProjectId(Integer workProjectId) {
        this.workProjectId = workProjectId;
    }

    public Integer getSurfaceId() {
        return surfaceId;
    }

    public void setSurfaceId(Integer surfaceId) {
        this.surfaceId = surfaceId;
    }

    @Override
    public String toString() {
        return "DelFinishedSurfaceParam{" +
                "workProjectId=" + workProjectId +
                ", surfaceId=" + surfaceId +
                '}';
    }
}
