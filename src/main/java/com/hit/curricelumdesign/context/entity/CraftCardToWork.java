package com.hit.curricelumdesign.context.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_craft_card_to_work")
public class CraftCardToWork {
    /**
     * id主键唯一自增非空
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "f_id")
    private Integer id;

    /**
     * 工艺卡片id
     */
    @Column(name = "f_craft_card_id")
    private Integer craftCardId;

    /**
     * 学生作业id
     */
    @Column(name = "f_work_id")
    private Integer workId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCraftCardId() {
        return craftCardId;
    }

    public void setCraftCardId(Integer craftCardId) {
        this.craftCardId = craftCardId;
    }

    public Integer getWorkId() {
        return workId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
    }
}