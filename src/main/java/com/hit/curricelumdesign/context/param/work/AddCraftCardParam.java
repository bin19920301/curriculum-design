package com.hit.curricelumdesign.context.param.work;

import com.hit.curricelumdesign.context.param.BaseRequestParam;

import javax.persistence.Column;

/**
 * @author xbr
 * @Date 2019-12-22
 * @ClassName AddCraftCardParam
 * @Description
 */
public class AddCraftCardParam {

    /**
     * 工艺卡片id
     */
    private Integer craftCardId;

    /**
     * 加工表面
     */
    private Integer surface;

    /**
     * 加工形式
     */
    private Integer processingMethod;

    /**
     * 工序内容
     */
    private String processContent;

    /**
     * 排序
     */
    private Integer sort;

    public Integer getCraftCardId() {
        return craftCardId;
    }

    public void setCraftCardId(Integer craftCardId) {
        this.craftCardId = craftCardId;
    }

    public Integer getSurface() {
        return surface;
    }

    public void setSurface(Integer surface) {
        this.surface = surface;
    }

    public Integer getProcessingMethod() {
        return processingMethod;
    }

    public void setProcessingMethod(Integer processingMethod) {
        this.processingMethod = processingMethod;
    }

    public String getProcessContent() {
        return processContent;
    }

    public void setProcessContent(String processContent) {
        this.processContent = processContent;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "AddCraftCardParam{" +
                "craftCardId=" + craftCardId +
                ", surface=" + surface +
                ", processingMethod=" + processingMethod +
                ", processContent='" + processContent + '\'' +
                ", sort=" + sort +
                '}';
    }
}
