package com.hit.curricelumdesign.context.param.workproject;

import com.hit.curricelumdesign.context.param.BaseRequestParam;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author xbr
 * @Date 2019-12-12
 * @ClassName AddWorkProjectParam
 * @Description
 */
public class AddWorkProjectParam extends BaseRequestParam {

    /**
     * 作业项目名称
     */
    @NotNull
    @Size(min = 1, max = 30)
    private String name;

    /**
     * 简介
     */
    @NotNull
    @Size(min = 1, max = 500)
    private String desc;

    /**
     * 文件id列表
     */
    private List<Integer> fileIdList;

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

    public List<Integer> getFileIdList() {
        return fileIdList;
    }

    public void setFileIdList(List<Integer> fileIdList) {
        this.fileIdList = fileIdList;
    }

    @Override
    public String toString() {
        return "AddWorkProjectParam{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", fileIdList=" + fileIdList +
                '}';
    }
}
