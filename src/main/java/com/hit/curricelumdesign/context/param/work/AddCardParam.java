package com.hit.curricelumdesign.context.param.work;

import com.hit.curricelumdesign.context.annotation.JsonArr;
import com.hit.curricelumdesign.context.param.BaseRequestParam;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author xbr
 * @Date 2019-12-22
 * @ClassName AddCardParam
 * @Description
 */
public class AddCardParam extends BaseRequestParam {

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

    /**
     * 工序列表
     */
    private List<ProcessParam> processList;

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

    public List<ProcessParam> getProcessList() {
        return processList;
    }

    public void setProcessList(List<ProcessParam> processList) {
        this.processList = processList;
    }

    @Override
    public String toString() {
        return "AddCardParam{" +
                "workId=" + workId +
                ", partNumber='" + partNumber + '\'' +
                ", partName='" + partName + '\'' +
                ", productType='" + productType + '\'' +
                ", materials='" + materials + '\'' +
                ", workblankWeight=" + workblankWeight +
                ", workblankKind='" + workblankKind + '\'' +
                ", processList=" + processList +
                '}';
    }
}
