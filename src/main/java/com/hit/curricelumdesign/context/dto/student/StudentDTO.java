package com.hit.curricelumdesign.context.dto.student;

public class StudentDTO {
    /**
     * 主键id自增
     */
    private Integer id;

    /**
     * 学号，字符串格式
     */
    private String number;

    /**
     * 学生姓名
     */
    private String name;

    /**
     * 关联的入学年份
     */
    private String enrollmentYear;

    /**
     * 关联的年级id，入学年份
     */
    private Integer enrollmentId;

    /**
     * 关联学院名称
     */
    private String academyName;

    /**
     * 关联的学院id
     */
    private Integer academyId;

    /**
     * 关联的班级名称
     */
    private String className;

    /**
     * 关联的班级的id
     */
    private Integer classId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getEnrollmentYear() {
        return enrollmentYear;
    }

    public void setEnrollmentYear(String enrollmentYear) {
        this.enrollmentYear = enrollmentYear;
    }

    public Integer getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(Integer enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public String getAcademyName() {
        return academyName;
    }

    public void setAcademyName(String academyName) {
        this.academyName = academyName;
    }

    public Integer getAcademyId() {
        return academyId;
    }

    public void setAcademyId(Integer academyId) {
        this.academyId = academyId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", enrollmentYear='" + enrollmentYear + '\'' +
                ", enrollmentId=" + enrollmentId +
                ", academyName='" + academyName + '\'' +
                ", academyId=" + academyId +
                ", className='" + className + '\'' +
                ", classId=" + classId +
                '}';
    }
}
