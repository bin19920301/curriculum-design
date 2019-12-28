package com.hit.curricelumdesign.context.dto.file;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import java.util.Date;

public class FileDTO {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 文件夹名称
     */
    private String folderName;

    /**
     * 文件夹id
     */
    private Integer folderId;

    /**
     * 文件名称
     */
    private String name;

    /**
     * 文件大小
     */
    private String size;

    /**
     * 创建者id
     */
    private Integer creatorId;

    /**
     * 创建者id
     */
    private String creatorName;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;

    /**
     * 使用总数
     */
    private Integer useCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public Integer getFolderId() {
        return folderId;
    }

    public void setFolderId(Integer folderId) {
        this.folderId = folderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getUseCount() {
        return useCount;
    }

    public void setUseCount(Integer useCount) {
        this.useCount = useCount;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }
}
