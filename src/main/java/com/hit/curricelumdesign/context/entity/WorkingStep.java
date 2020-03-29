package com.hit.curricelumdesign.context.entity;

import javax.persistence.*;
import java.util.Date;

public class WorkingStep {
    /**
     * id主键自增非空唯一
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "f_id")
    private Integer id;

    /**
     * 工艺卡片id
     */
    @Column(name = "f_card_id")
    private Integer cardId;

    /**
     * 工位id
     */
    @Column(name = "f_position_id")
    private Integer positionId;

    /**
     * 机床;1车床,2铣床,3刨床,4磨床,5钻床,6铰床
     */
    @Column(name = "f_tool")
    private Integer tool;

    /**
     * 刀具
     */
    @Column(name = "f_cutter")
    private String cutter;

    /**
     * 切削深度
     */
    @Column(name = "f_cut_depth")
    private String cutDepth;

    /**
     * 主轴转速
     */
    @Column(name = "f_mainshaft_speed")
    private String mainshaftSpeed;

    /**
     * 夹具或辅助工具
     */
    @Column(name = "f_fixture")
    private String fixture;

    /**
     * 走刀深度
     */
    @Column(name = "f_feeding_depth")
    private String feedingDepth;

    /**
     * 进给量
     */
    @Column(name = "f_load")
    private String load;

    /**
     * 切削速度
     */
    @Column(name = "f_cut_speed")
    private String cutSpeed;

    /**
     * 基本时间
     */
    @Column(name = "f_basic_time")
    private String basicTime;

    /**
     * 辅助时间
     */
    @Column(name = "f_assist_time")
    private String assistTime;

    /**
     * 工作地服务时间
     */
    @Column(name = "f_workspace_service_time")
    private String workspaceServiceTime;

    /**
     * 排序
     */
    @Column(name = "f_sort")
    private Integer sort;

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

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public Integer getTool() {
        return tool;
    }

    public void setTool(Integer tool) {
        this.tool = tool;
    }

    public String getCutter() {
        return cutter;
    }

    public void setCutter(String cutter) {
        this.cutter = cutter;
    }

    public String getCutDepth() {
        return cutDepth;
    }

    public void setCutDepth(String cutDepth) {
        this.cutDepth = cutDepth;
    }

    public String getMainshaftSpeed() {
        return mainshaftSpeed;
    }

    public void setMainshaftSpeed(String mainshaftSpeed) {
        this.mainshaftSpeed = mainshaftSpeed;
    }

    public String getFixture() {
        return fixture;
    }

    public void setFixture(String fixture) {
        this.fixture = fixture;
    }

    public String getFeedingDepth() {
        return feedingDepth;
    }

    public void setFeedingDepth(String feedingDepth) {
        this.feedingDepth = feedingDepth;
    }

    public String getLoad() {
        return load;
    }

    public void setLoad(String load) {
        this.load = load;
    }

    public String getCutSpeed() {
        return cutSpeed;
    }

    public void setCutSpeed(String cutSpeed) {
        this.cutSpeed = cutSpeed;
    }

    public String getBasicTime() {
        return basicTime;
    }

    public void setBasicTime(String basicTime) {
        this.basicTime = basicTime;
    }

    public String getAssistTime() {
        return assistTime;
    }

    public void setAssistTime(String assistTime) {
        this.assistTime = assistTime;
    }

    public String getWorkspaceServiceTime() {
        return workspaceServiceTime;
    }

    public void setWorkspaceServiceTime(String workspaceServiceTime) {
        this.workspaceServiceTime = workspaceServiceTime;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean delete) {
        isDelete = delete;
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
        return "WorkingStep{" +
                "id=" + id +
                ", cardId=" + cardId +
                ", positionId=" + positionId +
                ", tool=" + tool +
                ", cutter='" + cutter + '\'' +
                ", cutDepth='" + cutDepth + '\'' +
                ", mainshaftSpeed='" + mainshaftSpeed + '\'' +
                ", fixture='" + fixture + '\'' +
                ", feedingDepth='" + feedingDepth + '\'' +
                ", load='" + load + '\'' +
                ", cutSpeed='" + cutSpeed + '\'' +
                ", basicTime='" + basicTime + '\'' +
                ", assistTime='" + assistTime + '\'' +
                ", workspaceServiceTime='" + workspaceServiceTime + '\'' +
                ", sort=" + sort +
                ", isDelete=" + isDelete +
                ", creatorId=" + creatorId +
                ", createtime=" + createtime +
                ", updaterId=" + updaterId +
                ", updatetime=" + updatetime +
                '}';
    }
}
