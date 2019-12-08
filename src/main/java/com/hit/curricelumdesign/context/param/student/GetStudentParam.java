package com.hit.curricelumdesign.context.param.student;

import com.hit.curricelumdesign.context.param.BaseRequestParam;

import javax.validation.constraints.NotNull;

public class GetStudentParam extends BaseRequestParam {

    /**
     * 根据学生id获取管理员信息
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
        return "GetAdminParam{" +
                "id=" + id +
                '}';
    }
}
