package com.hit.curricelumdesign.context.entity;


import javax.persistence.*;
import java.util.Date;

public class ProcedureRules {
    /**
     * id主键自增非空唯一
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
     * 规则类型;1加工优先级2加工方法
     */
    @Column(name = "f_rules_type")
    private Integer rulesType;

    /**
     * 规则详情
     */
    @Column(name = "f_rules_details")
    private String rulesDetails;

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
    @Column(name = "f_createtime")
    private Date createtime;

    /**
     * 修改者
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

    public Integer getWorkProjectId() {
        return workProjectId;
    }

    public void setWorkProjectId(Integer workProjectId) {
        this.workProjectId = workProjectId;
    }

    public Integer getRulesType() {
        return rulesType;
    }

    public void setRulesType(Integer rulesType) {
        this.rulesType = rulesType;
    }

    public String getRulesDetails() {
        return rulesDetails;
    }

    public void setRulesDetails(String rulesDetails) {
        this.rulesDetails = rulesDetails;
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
}