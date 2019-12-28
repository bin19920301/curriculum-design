package com.hit.curricelumdesign.context.dto.folder;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class FolderDTO {

    /**
     * 文件夹id
     */
    private Integer id;

    /**
     * 文件夹名称
     */
    private String name;

    /**
     * 文件数量
     */
    private Integer num;

    /**
     * 创建日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;

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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
