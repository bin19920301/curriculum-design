package com.hit.curricelumdesign.context.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_enrollment_year")
public class EnrollmentYear {
    /**
     * id主键唯一自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "f_id")
    private Integer id;

    /**
     * 年级年份
     */
    @Column(name = "f_enrollment_year_id")
    private Integer enrollmentYearId;

    /**
     * 删除的标志位
     */
    @Column(name = "f_is_delete")
    private Boolean isDelete;

    /**
     * 创建者的id
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
     * 修改时操作者的id
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

    public Integer getEnrollmentYearId() {
        return enrollmentYearId;
    }

    public void setEnrollmentYearId(Integer enrollmentYearId) {
        this.enrollmentYearId = enrollmentYearId;
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