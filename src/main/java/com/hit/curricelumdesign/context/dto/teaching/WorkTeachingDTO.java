package com.hit.curricelumdesign.context.dto.teaching;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author xbr
 * @Date 2019-12-23
 * @ClassName WorkTeachingDTO
 * @Description
 */
public class WorkTeachingDTO {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 指导教师id
     */
    private Integer teacherId;

    /**
     * 指导教师名称
     */
    private String teacherName;

    /**
     * 教学名称
     */
    private String name;

    /**
     * 教师提示
     */
    private String teacherReminder;

    /**
     * 截止日期
     */
    private Date deadlineTime;

    /**
     * 状态 1：教学中 2：批阅中 3：批阅完成 4：已完成
     */
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "WorkTeachingDTO{" +
                "id=" + id +
                ", teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", name='" + name + '\'' +
                ", teacherReminder='" + teacherReminder + '\'' +
                ", deadlineTime=" + deadlineTime +
                ", status=" + status +
                '}';
    }
}
