package com.hit.curricelumdesign.context.param.enrollmentyear;

import javax.validation.constraints.NotNull;

public class EnrollmentYearBaseParam {
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
}
