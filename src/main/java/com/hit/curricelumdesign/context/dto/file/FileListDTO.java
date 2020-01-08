package com.hit.curricelumdesign.context.dto.file;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author xbr
 * @Date 2019-12-14
 * @ClassName FileListDto
 * @Description
 */
public class FileListDTO {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 文件夹id
     */
    private Integer folderId;

    /**
     * 文件名称
     */
    private String name;

    /**
     * 文件相对路径
     */
    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "FileListDto{" +
                "id=" + id +
                ", folderId=" + folderId +
                ", name='" + name + '\'' +
                '}';
    }

}
