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
     * 教学id
     */
    @Column(name = "f_teaching_id")
    private Integer teachingId;

    /**
     * 作业项目id
     */
    @Column(name = "f_work_project_id")
    private Integer workProjectId;

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
     * 提交时间
     */
    @Column(name = "f_submittime")
    private Date submittime;

    /**
     * 退回时间
     */
    @Column(name = "f_returntime")
    private Date returntime;

    /**
     * 作业状态：0未提交，1已提交，2已退回，3已完成
     */
    @Column(name = "f_status")
    private Integer status;

    /**
     * 删除标志位
     */
    @Column(name = "f_is_delete")
    private Boolean isDelete;

    /**
     * 创建时间
     */
    @Column(name = "f_createtime")
    private Date createtime;

    /**
     * 修改时间
     */
    @Column(name = "f_updatetime")
    private Date updatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeachingId() {
        return teachingId;
    }

    public void setTeachingId(Integer teachingId) {
        this.teachingId = teachingId;
    }

    public Integer getWorkProjectId() {
        return workProjectId;
    }

    public void setWorkProjectId(Integer workProjectId) {
        this.workProjectId = workProjectId;
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

    public Date getSubmittime() {
        return submittime;
    }

    public void setSubmittime(Date submittime) {
        this.submittime = submittime;
    }

    public Date getReturntime() {
        return returntime;
    }

    public void setReturntime(Date returntime) {
        this.returntime = returntime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}