package com.hit.curricelumdesign.context.param.student;

import com.hit.curricelumdesign.context.param.BaseRequestParam;

public class ConditionSearchStudentParam extends BaseRequestParam {
    /**
     * 入学年份id
     */
    private Integer enrollmentId;

    /**
     * 学院id
     */
    private Integer academyId;

    /**
     * 班级id
     */
    private Integer classId;

    public Integer getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(Integer enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public Integer getAcademyId() {
        return academyId;
    }

    public void setAcademyId(Integer academyId) {
        this.academyId = academyId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    @Override
    public String toString() {
        return "ConditionSearchStudentParam{" +
                "enrollmentId=" + enrollmentId +
                ", academyId=" + academyId +
                ", classId=" + classId +
                '}';
    }
}
