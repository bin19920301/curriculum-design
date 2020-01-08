package com.hit.curricelumdesign.context.param.workproject;

import com.hit.curricelumdesign.context.param.BaseRequestParam;

import javax.validation.constraints.NotNull;

/**
 * @author xbr
 * @Date 2019-12-14
 * @ClassName GetWorkProjectInfoParam
 * @Description
 */
public class GetWorkProjectInfoParam extends BaseRequestParam {

    @NotNull
    private Integer workProjectId;

    public Integer getWorkProjectId() {
        return workProjectId;
    }

    public void setWorkProjectId(Integer workProjectId) {
        this.workProjectId = workProjectId;
    }

    @Override
    public String toString() {
        return "GetWorkProjectInfoParam{" +
                "workProjectId=" + workProjectId +
                '}';
    }
}
