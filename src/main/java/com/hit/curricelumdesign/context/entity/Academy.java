package com.hit.curricelumdesign.context.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_academy")
public class Academy {
    /**
     * id主键唯一自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "f_id")
    private Integer id;

    /**
     * 学院名称
     */
    @Column(name = "f_name")
    private String name;

    /**
     * 删除的标志位
     */
    @Column(name = "f_is_delete")
    private Boolean isDelete;

    /**
     * 创建者的id
     */
    @Column(name = "f_create_id")
    private Integer createId;

    /**
     * 创建日期
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
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
        return "Academy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isDelete=" + isDelete +
                ", createId=" + createId +
                ", createtime=" + createtime +
                ", updaterId=" + updaterId +
                ", updatetime=" + updatetime +
                '}';
    }
}
