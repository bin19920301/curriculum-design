package com.hit.curricelumdesign.context.dto.teaching;

import com.hit.curricelumdesign.context.dto.work.WorkForTeacherDTO;

import java.util.Date;
import java.util.List;

public class TeachingInfoDTO {

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
    private String deadlineTime;

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

    /**
     * 作业详情列表（教师端）
     */
    private List<WorkForTeacherDTO> workForTeacherDTOList;

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

    public Long getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(Long studentCount) {
        this.studentCount = studentCount;
    }

    public String getTeacherReminder() {
        return teacherReminder;
    }

    public void setTeacherReminder(String teacherReminder) {
        this.teacherReminder = teacherReminder;
    }

    public String getDeadlineTime() {
        return deadlineTime;
    }

    public void setDeadlineTime(String deadlineTime) {
        this.deadlineTime = deadlineTime;
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

    public List<WorkForTeacherDTO> getWorkForTeacherDTOList() {
        return workForTeacherDTOList;
    }

    public void setWorkForTeacherDTOList(List<WorkForTeacherDTO> workForTeacherDTOList) {
        this.workForTeacherDTOList = workForTeacherDTOList;
    }

    @Override
    public String toString() {
        return "TeachingInfoDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studentCount=" + studentCount +
                ", teacherReminder='" + teacherReminder + '\'' +
                ", deadlineTime='" + deadlineTime + '\'' +
                ", status=" + status +
                ", statusDescribe='" + statusDescribe + '\'' +
                ", teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", creatorId=" + creatorId +
                ", workForTeacherDTOList=" + workForTeacherDTOList +
                '}';
    }
}

