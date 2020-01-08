package com.hit.curricelumdesign.context.param.enrollmentyear;

import com.hit.curricelumdesign.context.param.BaseRequestParam;

import javax.validation.constraints.NotNull;

/**
 * @author xbr
 * @Date 2019-12-09
 * @ClassName AddEnrollmentYearParam
 * @Description
 */
public class AddEnrollmentYearParam extends BaseRequestParam {

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

    @Override
    public String toString() {
        return "AddEnrollmentYearParam{" +
                "enrollmentYear=" + enrollmentYear +
                '}';
    }
}
