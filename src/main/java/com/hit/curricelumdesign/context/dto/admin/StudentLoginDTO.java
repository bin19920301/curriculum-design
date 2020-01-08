package com.hit.curricelumdesign.context.dto.admin;

/**
 * @author xbr
 * @Date 2019-12-27
 * @ClassName StudentLoginDTO
 * @Description
 */
public class StudentLoginDTO {
    private String token;
    private Integer studentId;
    private String studentName;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "StudentLoginDTO{" +
                "token='" + token + '\'' +
                ", studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                '}';
    }
}

