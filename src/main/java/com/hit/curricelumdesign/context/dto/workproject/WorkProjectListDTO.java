package com.hit.curricelumdesign.context.dto.workproject;

import java.util.List;

/**
 * @author xbr
 * @Date 2019-12-14
 * @ClassName WorkProjectListDTO
 * @Description
 */
public class WorkProjectListDTO {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 作业项目名称
     */
    private String name;

    /**
     * 简介
     */
    private String desc;

    /**
     * 使用次数
     */
    private Integer useCount;

    /**
     * 创建时间
     */
    private String createtime;

    /**
     * 创建者名称
     */
    private Integer creatorName;

    /**
     * 资料名称
     */
    private List<String> fileName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getUseCount() {
        return useCount;
    }

    public void setUseCount(Integer useCount) {
        this.useCount = useCount;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public Integer getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(Integer creatorName) {
        this.creatorName = creatorName;
    }

    public List<String> getFileName() {
        return fileName;
    }

    public void setFileName(List<String> fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "WorkProjectListDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", useCount=" + useCount +
                ", createtime='" + createtime + '\'' +
                ", creatorName=" + creatorName +
                ", fileName=" + fileName +
                '}';
    }
}
