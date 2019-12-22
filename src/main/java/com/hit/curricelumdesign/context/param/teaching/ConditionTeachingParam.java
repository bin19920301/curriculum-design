package com.hit.curricelumdesign.context.param.teaching;

import com.hit.curricelumdesign.context.param.BaseListRequestParam;

import javax.validation.constraints.NotNull;

public class ConditionTeachingParam extends BaseListRequestParam {

    /**
     * 当前教师id
     */
    @NotNull
    private Integer teacherId;

    /**
     * 教学状态
     */
    @NotNull
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
}
