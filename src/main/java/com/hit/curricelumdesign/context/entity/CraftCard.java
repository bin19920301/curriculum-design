package com.hit.curricelumdesign.context.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_craft_card")
public class CraftCard {
    /**
     * id主键自增风控唯一
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "f_id")
    private Integer id;

    /**
     * 工艺名称
     */
    @Column(name = "t_craft_name")
    private String tCraftName;

    /**
     * 加工表面
     */
    @Column(name = "t_finished_surface")
    private Integer tFinishedSurface;

    /**
     * 加工形式
     */
    @Column(name = "t_processing_method")
    private Integer tProcessingMethod;

    /**
     * 工序内容
     */
    @Column(name = "t_process _content")
    private String tProcessContent;

    /**
     * 删除标志位
     */
    @Column(name = "t_is_delete")
    private Boolean tIsDelete;

    /**
     * 创建者id
     */
    @Column(name = "t_creator_id")
    private Integer tCreatorId;

    /**
     * 创建时间
     */
    @Column(name = "t_create_time")
    private Date tCreateTime;

    /**
     * 修改者
     */
    @Column(name = "t_updater_id")
    private Integer tUpdaterId;

    /**
     * 更新时间
     */
    @Column(name = "t_update_time")
    private Date tUpdateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String gettCraftName() {
        return tCraftName;
    }

    public void settCraftName(String tCraftName) {
        this.tCraftName = tCraftName;
    }

    public Integer gettFinishedSurface() {
        return tFinishedSurface;
    }

    public void settFinishedSurface(Integer tFinishedSurface) {
        this.tFinishedSurface = tFinishedSurface;
    }

    public Integer gettProcessingMethod() {
        return tProcessingMethod;
    }

    public void settProcessingMethod(Integer tProcessingMethod) {
        this.tProcessingMethod = tProcessingMethod;
    }

    public String gettProcessContent() {
        return tProcessContent;
    }

    public void settProcessContent(String tProcessContent) {
        this.tProcessContent = tProcessContent;
    }

    public Boolean gettIsDelete() {
        return tIsDelete;
    }

    public void settIsDelete(Boolean tIsDelete) {
        this.tIsDelete = tIsDelete;
    }

    public Integer gettCreatorId() {
        return tCreatorId;
    }

    public void settCreatorId(Integer tCreatorId) {
        this.tCreatorId = tCreatorId;
    }

    public Date gettCreateTime() {
        return tCreateTime;
    }

    public void settCreateTime(Date tCreateTime) {
        this.tCreateTime = tCreateTime;
    }

    public Integer gettUpdaterId() {
        return tUpdaterId;
    }

    public void settUpdaterId(Integer tUpdaterId) {
        this.tUpdaterId = tUpdaterId;
    }

    public Date gettUpdateTime() {
        return tUpdateTime;
    }

    public void settUpdateTime(Date tUpdateTime) {
        this.tUpdateTime = tUpdateTime;
    }
}