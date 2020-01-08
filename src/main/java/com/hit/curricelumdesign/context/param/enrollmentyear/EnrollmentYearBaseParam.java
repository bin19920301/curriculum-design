package com.hit.curricelumdesign.context.param.enrollmentyear;

import com.hit.curricelumdesign.context.param.BaseRequestParam;

import javax.validation.constraints.NotNull;

public class EnrollmentYearBaseParam extends BaseRequestParam {
    /**
     * 入学年份id
     */
    @NotNull
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "EnrollmentYearBaseParam{" +
                "id=" + id +
                '}';
    }
}
