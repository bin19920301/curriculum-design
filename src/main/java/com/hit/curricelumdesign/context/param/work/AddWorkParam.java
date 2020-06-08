package com.hit.curricelumdesign.context.param.work;

public class AddWorkParam {

    /**
     * 教学id
     */
    private Integer teachingId;

    /**
     * 作业项目id
     */
    private Integer workProjectId;

    /**
     * 学生id
     */
    private Integer studentId;

    public Integer getWorkProjectId() {
        return workProjectId;
    }

    public void setWorkProjectId(Integer workProjectId) {
        this.workProjectId = workProjectId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getTeachingId() {
        return teachingId;
    }

    public void setTeachingId(Integer teachingId) {
        this.teachingId = teachingId;
    }

    @Override
    public String toString() {
        return "AddWorkParam{" +
                "teachingId=" + teachingId +
                ", workProjectId=" + workProjectId +
                ", studentId=" + studentId +
                '}';
    }
}
