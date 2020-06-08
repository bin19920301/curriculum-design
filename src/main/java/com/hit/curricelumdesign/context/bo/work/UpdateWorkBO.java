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

    public Integer getLoginStudentId() {
        return studentId;
    }

    public void setLoginStudentId(Integer loginStudentId) {
        this.studentId = loginStudentId;
    }

    @Override
    public String toString() {
        return "UpdateWorkBO{" +
                "workProjectId=" + workProjectId +
                ", studentId=" + studentId +
                '}';
    }
}
