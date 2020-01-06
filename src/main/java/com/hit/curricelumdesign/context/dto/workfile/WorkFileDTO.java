package com.hit.curricelumdesign.context.dto.workfile;

public class WorkFileDTO {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 文件名称
     */
    private String name;

    /**
     * 文件大小
     */
    private String size;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
