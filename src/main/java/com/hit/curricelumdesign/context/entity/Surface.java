package com.hit.curricelumdesign.context.entity;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "t_surface")
public class Surface {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "f_id")
    private Integer id;

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