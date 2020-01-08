package com.hit.curricelumdesign.context.dto.admin;

/**
 * @author xbr
 * @Date 2019-12-27
 * @ClassName TeacherLoginDTO
 * @Description
 */
public class TeacherLoginDTO {
    private String token;
    private Integer teacherId;
    private String teacherName;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    @Override
    public String toString() {
        return "TeacherLoginDTO{" +
                "token='" + token + '\'' +
                ", teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                '}';
    }
}


