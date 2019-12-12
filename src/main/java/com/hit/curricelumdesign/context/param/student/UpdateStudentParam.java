package com.hit.curricelumdesign.context.param.student;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateStudentParam extends StudentBaseParam {
    /**
     * 主键id自增
     */
    @NotNull
    private Integer id;

    /**
     * 关联的学院id
     */
    @NotNull
    private Integer academyId;

    /**
     * 关联的年级id，入学年份
     */
    @NotNull
    private Integer enrollmentId;

    /**
     * 关联的班级的id
     */
    @NotNull
    private Integer classId;

    /**
     * 学生姓名
     */
    @NotNull
    @Size(min = 0,max = 30 ,message = "学生姓名")
    private String name;

    /**
     * 学号，字符串格式
     */
    @NotNull
    @Size(min = 0,max = 30 ,message = "学号")
    private String number;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
