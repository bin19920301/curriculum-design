package com.hit.curricelumdesign.context.dto.teaching;

import java.util.Date;

public class TeachingListDTO {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 教学名称
     */
    private String name;

    /**
     * 参与学生人数
     */
    private Long studentCount;

    /**
     * 教师提示
     */
    private String teacherReminder;

    /**
     * 截止日期
     */
    private Date deadlineTime;

    /**
     * 状态码 1：教学中 2：批阅中 3：批阅完成 4：已完成
     */
    private Integer status;

    /**
     * 状态描述
     */
    private String statusDescribe;

    /**
     * 指导教师id
     */
    private Integer teacherId;

    /**
     * 教师姓名
     */
    private String teacherName;

    /**
     * 创建者id（理论上和指导教师应该是一个人）
     */
    private Integer creatorId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacherReminder() {
        return teacherReminder;
    }

    public void setTeacherReminder(String teacherReminder) {
        this.teacherReminder = teacherReminder;
    }

    public Date getDeadlineTime() {
        return deadlineTime;
    }

    public void setDeadlineTime(Date deadlineTime) {
        this.deadlineTime = deadlineTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public String getStatusDescribe() {
        return statusDescribe;
    }

    public void setStatusDescribe(String statusDescribe) {
        this.statusDescribe = statusDescribe;
    }

    public Long getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(Long studentCount) {
        this.studentCount = studentCount;
    }
}
