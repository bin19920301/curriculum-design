package com.hit.curricelumdesign.context.param.teacher;

import com.hit.curricelumdesign.context.param.BaseRequestParam;

import javax.validation.constraints.Null;
import javax.validation.constraints.Size;


public class UpdateTeacherParam extends BaseRequestParam {

    /**
     * id主键自增唯一
     */
    @Null
    private Integer id;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "UpdateTeacherParam{" +
                "id=" + id +
                ", academyId=" + academyId +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
