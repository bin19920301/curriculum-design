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
     * 加工表面id
     */
    private Integer surfaceId;

    /**
     * 加工形式id
     */
    private Integer processingMethodId;

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

    public Integer getSurfaceId() {
        return surfaceId;
    }

    public void setSurfaceId(Integer surfaceId) {
        this.surfaceId = surfaceId;
    }

    public Integer getProcessingMethodId() {
        return processingMethodId;
    }

    public void setProcessingMethodId(Integer processingMethodId) {
        this.processingMethodId = processingMethodId;
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
                ", surfaceId=" + surfaceId +
                ", processingMethodId=" + processingMethodId +
                ", processContent='" + processContent + '\'' +
                ", sort=" + sort +
                '}';
    }
}
