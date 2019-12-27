package com.hit.curricelumdesign.context.param.teacher;

import com.hit.curricelumdesign.context.param.BaseRequestParam;

import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

public class AddTeacherParam extends BaseRequestParam {
    /**
     * 关联的学院id
     */
    @Null
    private Integer academyId;

    /**
     * 教师编号
     */
    @Null
    @Size(min = 0, max = 30, message = "教师编号")
    private String number;

    /**
     * 教师姓名
     */
    @Null
    @Size(min = 0, max = 30, message = "教师姓名")
    private String name;


    public Integer getAcademyId() {
        return academyId;
    }

    public void setAcademyId(Integer academyId) {
        this.academyId = academyId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
