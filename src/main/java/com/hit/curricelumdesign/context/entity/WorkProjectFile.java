package com.hit.curricelumdesign.context.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_work_project_file")
public class WorkProjectFile {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "f_id")
    private Integer id;

    /**
     * 作业项目id
     */
    @Column(name = "f_work_project_id")
    private Integer workProjectId;

    /**
     * 文件id
     */
    @Column(name = "f_file_id")
    private Integer fileId;

    /**
     * 文件使用类型 1：资料 2：参考方案
     */
    @Column(name = "f_file_type")
    private Integer fileType;

    /**
     * 是否删除 0：否 1：是
     */
    @Column(name = "f_is_delete")
    private Boolean isDelete;

    /**
     * 创建时间
     */
    @Column(name = "f_createtime")
    private Date createtime;

    /**
     * 创建者id
     */
    @Column(name = "f_creator_id")
    private Integer creatorId;

    /**
     * 最后更新时间
     */
    @Column(name = "f_updatetime")
    private Date updatetime;

    /**
     * 最后更新者id
     */
    @Column(name = "f_updater_id")
    private Integer updaterId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWorkProjectId() {
        return workProjectId;
    }

    public void setWorkProjectId(Integer workProjectId) {
        this.workProjectId = workProjectId;
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
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

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getUpdaterId() {
        return updaterId;
    }

    public void setUpdaterId(Integer updaterId) {
        this.updaterId = updaterId;
    }

    public Integer getFileType() {
        return fileType;
    }

    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }

    @Override
    public String toString() {
        return "WorkProjectFile{" +
                "id=" + id +
                ", workProjectId=" + workProjectId +
                ", fileId=" + fileId +
                ", fileType=" + fileType +
                ", isDelete=" + isDelete +
                ", createtime=" + createtime +
                ", creatorId=" + creatorId +
                ", updatetime=" + updatetime +
                ", updaterId=" + updaterId +
                '}';
    }
}
