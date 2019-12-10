package com.hit.curricelumdesign.context.param.enrollmentyear;

import javax.validation.constraints.NotNull;

public class UpdateEnrollmentYearParam extends EnrollmentYearBaseParam{
    /**
     * 入学年份
     */
    @NotNull
    private Integer enrollmentYear;

    public Integer getEnrollmentYear() {
        return enrollmentYear;
    }

    public void setEnrollmentYear(Integer enrollmentYear) {
        this.enrollmentYear = enrollmentYear;
    }
}
