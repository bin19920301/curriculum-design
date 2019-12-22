package com.hit.curricelumdesign.context.param.workmessage;

import com.hit.curricelumdesign.context.param.BaseRequestParam;

import javax.validation.constraints.NotNull;

/**
 * @author xbr
 * @Date 2019-12-22
 * @ClassName CountTeacherUnreadMessageParam
 * @Description
 */
public class CountTeacherUnreadMessageParam extends BaseRequestParam {

    /**
     * 教师id
     */
    @NotNull
    private Integer teacherId;

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "CountTeacherUnreadMessageParam{" +
                "teacherId=" + teacherId +
                '}';
    }
}
