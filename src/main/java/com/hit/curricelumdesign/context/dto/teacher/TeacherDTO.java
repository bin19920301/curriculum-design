package com.hit.curricelumdesign.context.dto.teacher;

public class TeacherDTO {

    /**
     * id主键自增唯一
     */
    private Integer id;

    /**
     * 教师编号
     */
    private String number;

    /**
     * 教师姓名
     */
    private String name;

    /**
     * 关联的学院名称
     */
    private String academyName;

    /**
     * 关联的学院id
     */
    private Integer academyId;

    /**
     * 密码
     */
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getAcademyName() {
        return academyName;
    }

    public void setAcademyName(String academyName) {
        this.academyName = academyName;
    }

    public Integer getAcademyId() {
        return academyId;
    }

    public void setAcademyId(Integer academyId) {
        this.academyId = academyId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
