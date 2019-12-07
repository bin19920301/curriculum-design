package com.hit.curricelumdesign.context.param;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Description: 基础入参类
 * ClassName: BaseRequestParam
 * date: 2018年11月11日
 *
 * @author xbr
 * @since JDK 1.8
 */
public class BaseRequestParam {

    /**
     * 教师登录令牌
     */
    private String teacherToken;

    /**
     * 管理员登录令牌
     */
    private String adminToken;

    /**
     * 学生登录令牌
     */
    private String studentToken;

    public String getTeacherToken() {
        return teacherToken;
    }

    public void setTeacherToken(String teacherToken) {
        this.teacherToken = teacherToken;
    }

    public String getAdminToken() {
        return adminToken;
    }

    public void setAdminToken(String adminToken) {
        this.adminToken = adminToken;
    }

    public String getStudentToken() {
        return studentToken;
    }

    public void setStudentToken(String studentToken) {
        this.studentToken = studentToken;
    }

    @Override
    public String toString() {
        return "BaseRequestParam{" +
                "teacherToken='" + teacherToken + '\'' +
                ", adminToken='" + adminToken + '\'' +
                ", studentToken='" + studentToken + '\'' +
                '}';
    }
}
