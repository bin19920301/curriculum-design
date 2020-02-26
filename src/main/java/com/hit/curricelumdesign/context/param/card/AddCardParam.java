package com.hit.curricelumdesign.context.param.card;

import javax.persistence.Column;

public class AddCardParam {

    /**
     * 作业id
     */
    private Integer workId;

    /**
     * 零件号
     */
    private String partNumber;

    /**
     * 零件名称
     */
    private String partName;

    /**
     * 生产类型
     */
    private String productType;

    /**
     * 材料
     */
    private String materials;

    /**
     * 毛坯重量
     */
    private Double workblankWeight;

    /**
     * 毛坯类型
     */
    private String workblankKind;

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

    public Double getWorkblankWeight() {
        return workblankWeight;
    }

    public void setWorkblankWeight(Double workblankWeight) {
        this.workblankWeight = workblankWeight;
    }

    public String getWorkblankKind() {
        return workblankKind;
    }

    public void setWorkblankKind(String workblankKind) {
        this.workblankKind = workblankKind;
    }
}
