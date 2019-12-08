package com.hit.curricelumdesign.context.param.teacher;

import javax.validation.constraints.Null;


public class UpdateTeacherParam {

    /**
     * id主键自增唯一
     */
    @Null
    private Integer id;

    /**
     * 关联的学院id
     */
    @Null
    private Integer academyId;

    /**
     * 教师编号
     */
    @Null
    private String number;

    /**
     * 教师姓名
     */
    @Null
    private String name;

    /**
     * 登录密码
     */
    @Null
    private String password;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAcademyId() {
        return academyId;
    }

    public void setAcademyId(Integer academyId) {
        this.academyId = academyId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
