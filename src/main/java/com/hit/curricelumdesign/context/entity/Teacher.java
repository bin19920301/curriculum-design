package com.hit.curricelumdesign.context.entity;

import javax.persistence.*;
import java.util.Date;

public class Teacher {
    /**
     * id主键自增唯一
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "f_id")
    private Integer id;

    /**
     * 关联的学院id
     */
    @Column(name = "f_academy_id")
    private Integer academyId;

    /**
     * 教师的登录账号，预设的管理员账号也是一个特殊的教师
     */
    @Column(name = "f_username")
    private String username;

    /**
     * 教师的登录的密码
     */
    @Column(name = "f_password")
    private String password;

    /**
     * 教师姓名
     */
    @Column(name = "f_name")
    private String name;

    /**
     * 教师编号
     */
    @Column(name = "f_teacher_number")
    private String teacherNumber;

    /**
     * 删除标志位
     */
    @Column(name = "f_is_delete")
    private Boolean isDelete;

    /**
     * 创建者id
     */
    @Column(name = "f_creator_id")
    private Integer creatorId;

    /**
     * 创建时间
     */
    @Column(name = "f_create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    /**
     * 更新时操作者的id
     */
    @Column(name = "f_updater_id")
    private Integer updaterId;

    /**
     * 更新时间
     */
    @Column(name = "f_update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacherNumber() {
        return teacherNumber;
    }

    public void setTeacherNumber(String teacherNumber) {
        this.teacherNumber = teacherNumber;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdaterId() {
        return updaterId;
    }

    public void setUpdaterId(Integer updaterId) {
        this.updaterId = updaterId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}