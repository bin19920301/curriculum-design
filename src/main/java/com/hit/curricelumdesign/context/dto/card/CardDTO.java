package com.hit.curricelumdesign.context.dto.card;

import com.hit.curricelumdesign.context.dto.process.ProcessDTO;

import java.util.List;

public class CardDTO {

    /**
     * 工艺卡片id
     */
    private Integer cardId;

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
    private String workblankWeight;

    /**
     * 毛坯类型
     */
    private String workblankKind;

    /**
     * 工序集合
     */
    private List<ProcessDTO> processList;

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
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

    public List<ProcessDTO> getProcessList() {
        return processList;
    }

    public void setProcessList(List<ProcessDTO> processList) {
        this.processList = processList;
    }

    @Override
    public String toString() {
        return "CardDTO{" +
                "cardId=" + cardId +
                ", partNumber='" + partNumber + '\'' +
                ", partName='" + partName + '\'' +
                ", productType='" + productType + '\'' +
                ", materials='" + materials + '\'' +
                ", workblankWeight='" + workblankWeight + '\'' +
                ", workblankKind='" + workblankKind + '\'' +
                ", processList=" + processList +
                '}';
    }
}
