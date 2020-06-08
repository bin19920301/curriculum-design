package com.hit.curricelumdesign.context.param.teaching;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hit.curricelumdesign.context.annotation.JsonArr;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class UpdateTeachingParam extends TeachingBaseParam {


    /**
     * 教学名称
     */
    @NotNull
    private String name;

    /**
     * 教师提示
     */
    @NotNull
    private String teacherReminder;

    /**
     * 截止日期
     */
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date deadlineTime;

    //这里应该有更新的作业集合
    @JsonArr(type = StudentWorkProjectParam.class, paramName = "works")
    private List<StudentWorkProjectParam> works;


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

    @Override
    public String toString() {
        return "UpdateTeachingParam{" +
                "name='" + name + '\'' +
                ", teacherReminder='" + teacherReminder + '\'' +
                ", deadlineTime=" + deadlineTime +
                ", works=" + works +
                '}';
    }
}
