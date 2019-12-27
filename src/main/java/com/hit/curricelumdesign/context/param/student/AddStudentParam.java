package com.hit.curricelumdesign.context.param.student;

import com.hit.curricelumdesign.context.param.BaseRequestParam;

import javax.validation.constraints.Size;

public class AddStudentParam extends BaseRequestParam {

    /**
     * 学号，字符串格式
     */
    @Size(min = 0, max = 30, message = "学号")
    private String number;
    /**
     * 学生姓名
     */
    @Size(min = 0, max = 30, message = "学生姓名")
    private String name;

    /**
     * 关联的学院id
     */
    private Integer academyId;

    /**
     * 关联的年级id，入学年份
     */
    private Integer enrollmentId;

    /**
     * 关联的班级的id
     */
    private Integer classId;

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

    public Integer getAcademyId() {
        return academyId;
    }

    public void setAcademyId(Integer academyId) {
        this.academyId = academyId;
    }

    public Integer getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(Integer enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }
}
