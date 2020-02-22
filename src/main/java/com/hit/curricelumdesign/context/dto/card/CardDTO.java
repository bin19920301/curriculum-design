package com.hit.curricelumdesign.context.dto.card;

import com.hit.curricelumdesign.context.dto.process.ProcessDTO;

import java.util.List;

public class CardDTO {

    /**
     * 工艺卡片id
     */
    private Integer id;

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

    /**
     * 工序集合
     */
    private List<ProcessDTO> processDTOList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<ProcessDTO> getProcessDTOList() {
        return processDTOList;
    }

    public void setProcessDTOList(List<ProcessDTO> processDTOList) {
        this.processDTOList = processDTOList;
    }
}
