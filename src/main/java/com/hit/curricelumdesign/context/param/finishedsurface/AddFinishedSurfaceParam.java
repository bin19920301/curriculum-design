package com.hit.curricelumdesign.context.param.finishedsurface;

import com.hit.curricelumdesign.context.param.BaseRequestParam;

/**
 * @author xbr
 * @Date 2020-02-23
 * @ClassName AddFinishedSurfaceParam
 * @Description
 */
public class AddFinishedSurfaceParam extends BaseRequestParam {


    /**
     * 作业项目id
     */
    private Integer workProjectId;

    /**
     * 表面id
     */
    private Integer surfaceId;

    /**
     * 类型;1平面,2外圆,3孔
     */
    private Integer type;

    /**
     * 名称
     */
    private String name;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AddFinishedSurfaceParam{" +
                "workProjectId=" + workProjectId +
                ", surfaceId=" + surfaceId +
                ", type=" + type +
                ", name='" + name + '\'' +
                '}';
    }
}
