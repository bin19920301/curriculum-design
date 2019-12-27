package com.hit.curricelumdesign.context.param;

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

    /**
     * 教师id
     */
    private Integer loginTeacherId;

    /**
     * 管理员id
     */
    private Integer loginAdminId;

    /**
     * 学生id
     */
    private Integer loginStudentId;

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

    public Integer getLoginTeacherId() {
        return loginTeacherId;
    }

    public void setLoginTeacherId(Integer loginTeacherId) {
        this.loginTeacherId = loginTeacherId;
    }

    public Integer getLoginAdminId() {
        return loginAdminId;
    }

    public void setLoginAdminId(Integer loginAdminId) {
        this.loginAdminId = loginAdminId;
    }

    public Integer getLoginStudentId() {
        return loginStudentId;
    }

    public void setLoginStudentId(Integer loginStudentId) {
        this.loginStudentId = loginStudentId;
    }

    @Override
    public String toString() {
        return "BaseRequestParam{" +
                "teacherToken='" + teacherToken + '\'' +
                ", adminToken='" + adminToken + '\'' +
                ", studentToken='" + studentToken + '\'' +
                ", teacherId=" + loginTeacherId +
                ", adminId=" + loginAdminId +
                ", studentId=" + loginStudentId +
                '}';
    }
}
