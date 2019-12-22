package com.hit.curricelumdesign.context.param.workmessage;

import com.hit.curricelumdesign.context.param.BaseRequestParam;

import javax.validation.constraints.NotNull;

/**
 * @author xbr
 * @Date 2019-12-22
 * @ClassName CountStudentUnreadMessageParam
 * @Description
 */
public class CountStudentUnreadMessageParam extends BaseRequestParam {

    /**
     * 学生id
     */
    @NotNull
    private Integer studentId;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "CountStudentUnreadMessageParam{" +
                "studentId=" + studentId +
                '}';
    }
}
