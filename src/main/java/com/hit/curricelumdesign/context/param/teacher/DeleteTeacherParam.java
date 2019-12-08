package com.hit.curricelumdesign.context.param.teacher;

import com.hit.curricelumdesign.context.param.BaseRequestParam;

import javax.validation.constraints.NotNull;
public class DeleteTeacherParam extends BaseRequestParam {
    /**
     * 教师id
     */
    @NotNull
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
