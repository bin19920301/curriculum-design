package com.hit.curricelumdesign.context.dto.work;

public class WorkForTeacherDTO {
    //作业自身信息

    /**
     * 作业id
     */
    private Integer id;

    /**
     * 作业状态：0未提交，1已提交，2已退回，3已完成
     */
    private Integer status;

    /**
     * 作业状态描述
     */
    private String statusDescribe;

    //学生部分信息

    /**
     * 学生主键
     */
    private Integer studentId;

    /**
     * 学号，字符串格式
     */
    private String studentNumber;

    /**
     * 学生姓名
     */
    private String studentName;

    /**
     * 关联的入学年份
     */
    private String enrollmentYear;

    /**
     * 关联学院名称
     */
    private String academyName;

    /**
     * 关联的班级名称
     */
    private String className;

    //作业项目部分信息

    /**
     * 作业项目id
     */
    private Integer workProjectId;

    /**
     * 作业项目名称
     */
    private String workProjectName;

    /**
     * 分数
     */
    private Integer score;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusDescribe() {
        return statusDescribe;
    }

    public void setStatusDescribe(String statusDescribe) {
        this.statusDescribe = statusDescribe;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getEnrollmentYear() {
        return enrollmentYear;
    }

    public void setEnrollmentYear(String enrollmentYear) {
        this.enrollmentYear = enrollmentYear;
    }

    public String getAcademyName() {
        return academyName;
    }

    public void setAcademyName(String academyName) {
        this.academyName = academyName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getWorkProjectId() {
        return workProjectId;
    }

    public void setWorkProjectId(Integer workProjectId) {
        this.workProjectId = workProjectId;
    }

    public String getWorkProjectName() {
        return workProjectName;
    }

    public void setWorkProjectName(String workProjectName) {
        this.workProjectName = workProjectName;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "WorkForTeacherDTO{" +
                "id=" + id +
                ", status=" + status +
                ", statusDescribe='" + statusDescribe + '\'' +
                ", studentId=" + studentId +
                ", studentNumber='" + studentNumber + '\'' +
                ", studentName='" + studentName + '\'' +
                ", enrollmentYear='" + enrollmentYear + '\'' +
                ", academyName='" + academyName + '\'' +
                ", className='" + className + '\'' +
                ", workProjectId=" + workProjectId +
                ", workProjectName='" + workProjectName + '\'' +
                ", score=" + score +
                '}';
    }
}
