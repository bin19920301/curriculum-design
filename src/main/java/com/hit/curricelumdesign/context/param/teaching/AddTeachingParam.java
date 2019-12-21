package com.hit.curricelumdesign.context.param.teaching;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class AddTeachingParam {
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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm" )
    private Date deadlineTime;

    //这里缺少作业的集合
    List<StudentWorkProjectParam> works;

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

    public List<StudentWorkProjectParam> getWorks() {
        return works;
    }

    public void setWorks(List<StudentWorkProjectParam> works) {
        this.works = works;
    }
}
