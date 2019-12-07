package com.hit.curricelumdesign.context.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_work")
public class Work {
    /**
     * id主键自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "f_id")
    private Integer id;

    /**
     * 课程设计id
     */
    @Column(name = "f_project_id")
    private Integer projectId;

    /**
     * 教学id
     */
    @Column(name = "f_teaching_id")
    private Integer teachingId;

    /**
     * 学生id
     */
    @Column(name = "f_student_id")
    private Integer studentId;

    /**
     * 作业分数
     */
    @Column(name = "f_score")
    private Integer score;

    /**
     * 作业状态：0未提交，1已提交，2退回，3已完成
     */
    @Column(name = "f_status")
    private Integer status;

    /**
     * 提交时间
     */
    @Column(name = "f_submit_time")
    private Date submitTime;

    /**
     * 删除标志位
     */
    @Column(name = "f_is_delete")
    private Boolean isDelete;

    /**
     * 创建时间
     */
    @Column(name = "f_create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    /**
     * 修改者id
     */
    @Column(name = "f_updater_id")
    private Integer updaterId;

    /**
     * 修改时间
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

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getTeachingId() {
        return teachingId;
    }

    public void setTeachingId(Integer teachingId) {
        this.teachingId = teachingId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
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