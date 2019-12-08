package com.hit.curricelumdesign.context.param.student;

import com.hit.curricelumdesign.context.param.BaseRequestParam;

import javax.validation.constraints.NotNull;

public class StudentBaseParam extends BaseRequestParam {

    /**
     * 学生id
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
