package com.hit.curricelumdesign.context.entity;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "t_file")
public class File {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "f_id")
    private Integer id;

    /**
     * 文件夹id
     */
    @Column(name = "f_folder_id")
    private Integer folderId;

    /**
     * 文件名称
     */
    @Column(name = "f_name")
    private String name;

    /**
     * 文件大小
     */
    @Column(name = "f_size")
    private String size;

    /**
     * 文件路径
     */
    @Column(name = "f_path")
    private String path;

    /**
     * 使用总数
     */
    @Column(name = "f_use_count")
    private Integer useCount;

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

    public Integer getFolderId() {
        return folderId;
    }

    public void setFolderId(Integer folderId) {
        this.folderId = folderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getUseCount() {
        return useCount;
    }

    public void setUseCount(Integer useCount) {
        this.useCount = useCount;
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
}