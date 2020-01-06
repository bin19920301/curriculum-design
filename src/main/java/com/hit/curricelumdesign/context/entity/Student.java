package com.hit.curricelumdesign.context.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_student")
public class Student {
    /**
     * 主键id自增
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
     * 关联的年级id，入学年份
     */
    @Column(name = "f_enrollment_id")
    private Integer enrollmentId;

    /**
     * 关联的班级的id
     */
    @Column(name = "f_class_id")
    private Integer classId;

    /**
     * 学生姓名
     */
    @Column(name = "f_name")
    private String name;

    /**
     * 学号，字符串格式
     */
    @Column(name = "f_number")
    private String number;

    /**
     * 删除标志位
     */
    @Column(name = "f_is_delete")
    private Byte isDelete;

    /**
     * 创建者id
     */
    @Column(name = "f_creator_id")
    private Integer creatorId;

    /**
     * 创建时间
     */
    @Column(name = "f_createtime")
    private Date createtime;

    /**
     * 更新时操作者的id
     */
    @Column(name = "f_updater_id")
    private Integer updaterId;

    /**
     * 更新时间
     */
    @Column(name = "f_updatetime")
    private Date updatetime;

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

    public Integer getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(Integer enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getUpdaterId() {
        return updaterId;
    }

    public void setUpdaterId(Integer updaterId) {
        this.updaterId = updaterId;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", academyId=" + academyId +
                ", enrollmentId=" + enrollmentId +
                ", classId=" + classId +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", isDelete=" + isDelete +
                ", creatorId=" + creatorId +
                ", createtime=" + createtime +
                ", updaterId=" + updaterId +
                ", updatetime=" + updatetime +
                '}';
    }
}
