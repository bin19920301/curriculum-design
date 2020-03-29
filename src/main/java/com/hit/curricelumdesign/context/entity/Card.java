package com.hit.curricelumdesign.context.entity;


import javax.persistence.*;
import java.util.Date;

public class Card {
    /**
     * id主键自增风控唯一
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "f_id")
    private Integer id;

    /**
     * 作业id
     */
    @Column(name = "f_work_id")
    private Integer workId;

    /**
     * 零件号
     */
    @Column(name = "f_part_number")
    private String partNumber;

    /**
     * 零件名称
     */
    @Column(name = "f_part_name")
    private String partName;

    /**
     * 生产类型
     */
    @Column(name = "f_product_type")
    private String productType;

    /**
     * 材料
     */
    @Column(name = "f_materials")
    private String materials;

    /**
     * 毛坯重量
     */
    @Column(name = "f_workblank_weight")
    private String workblankWeight;

    /**
     * 毛坯类型
     */
    @Column(name = "f_workblank_kind")
    private String workblankKind;

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

    public Integer getWorkId() {
        return workId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public String getWorkblankWeight() {
        return workblankWeight;
    }

    public void setWorkblankWeight(String workblankWeight) {
        this.workblankWeight = workblankWeight;
    }

    public String getWorkblankKind() {
        return workblankKind;
    }

    public void setWorkblankKind(String workblankKind) {
        this.workblankKind = workblankKind;
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
        return "Card{" +
                "id=" + id +
                ", workId=" + workId +
                ", partNumber='" + partNumber + '\'' +
                ", partName='" + partName + '\'' +
                ", productType='" + productType + '\'' +
                ", materials='" + materials + '\'' +
                ", workblankWeight='" + workblankWeight + '\'' +
                ", workblankKind='" + workblankKind + '\'' +
                ", isDelete=" + isDelete +
                ", creatorId=" + creatorId +
                ", createtime=" + createtime +
                ", updaterId=" + updaterId +
                ", updatetime=" + updatetime +
                '}';
    }
}
