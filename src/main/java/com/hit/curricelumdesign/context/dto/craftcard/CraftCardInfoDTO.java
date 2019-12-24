package com.hit.curricelumdesign.context.dto.craftcard;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author xbr
 * @Date 2019-12-24
 * @ClassName CraftCardInfoDTO
 * @Description
 */
public class CraftCardInfoDTO {
    /**
     * id主键自增风控唯一
     */
    private Integer id;

    /**
     * 加工表面id
     */
    private Integer surfaceId;

    /**
     * 加工表面名称
     */
    private String surfaceName;

    /**
     * 加工形式id
     */
    private Integer processingMethodId;

    /**
     * 加工形式名称
     */
    private String processingMethodName;

    /**
     * 工序内容
     */
    private String processContent;

    /**
     * 排序
     */
    private Integer sort;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSurfaceId() {
        return surfaceId;
    }

    public void setSurfaceId(Integer surfaceId) {
        this.surfaceId = surfaceId;
    }

    public String getSurfaceName() {
        return surfaceName;
    }

    public void setSurfaceName(String surfaceName) {
        this.surfaceName = surfaceName;
    }

    public Integer getProcessingMethodId() {
        return processingMethodId;
    }

    public void setProcessingMethodId(Integer processingMethodId) {
        this.processingMethodId = processingMethodId;
    }

    public String getProcessingMethodName() {
        return processingMethodName;
    }

    public void setProcessingMethodName(String processingMethodName) {
        this.processingMethodName = processingMethodName;
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
        return "CraftCardInfoDTO{" +
                "id=" + id +
                ", surfaceId=" + surfaceId +
                ", surfaceName='" + surfaceName + '\'' +
                ", processingMethodId=" + processingMethodId +
                ", processingMethodName='" + processingMethodName + '\'' +
                ", processContent='" + processContent + '\'' +
                ", sort=" + sort +
                '}';
    }
}
