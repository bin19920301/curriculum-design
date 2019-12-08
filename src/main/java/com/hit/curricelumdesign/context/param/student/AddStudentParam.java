package com.hit.curricelumdesign.context.param.student;

public class AddStudentParam {

    /**
     * 学号，字符串格式
     */
    private String number;
    /**
     * 学生姓名
     */
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