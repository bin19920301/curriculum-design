package com.hit.curricelumdesign.context.dto.teaching;

import java.util.Date;

public class TeachingDTO {
    /**
     * 主键id
     */
    private Integer id;

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
}
