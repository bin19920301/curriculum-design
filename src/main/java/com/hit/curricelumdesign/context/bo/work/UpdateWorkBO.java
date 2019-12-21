package com.hit.curricelumdesign.context.bo.work;

public class UpdateWorkBO extends WorkBaseBO {

    /**
     * 作业项目id
     */
    private Integer workProjectId;

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
}
