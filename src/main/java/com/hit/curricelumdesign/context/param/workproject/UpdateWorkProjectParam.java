package com.hit.curricelumdesign.context.param.workproject;

import com.hit.curricelumdesign.context.param.BaseRequestParam;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author xbr
 * @Date 2019-12-12
 * @ClassName AddWorkProjectParam
 * @Description
 */
public class UpdateWorkProjectParam extends BaseRequestParam {

    /**
     * 作业项目id
     */
    private Integer id;

    /**
     * 作业项目名称
     */
    @NotNull
    @Size(min = 1, max = 30, message = "名称")
    private String name;

    /**
     * 简介
     */
    @NotNull
    @Size(min = 1, max = 500, message = "简介")
    private String desc;

    /**
     * 文件id列表
     */
    private List<Integer> fileIdList;

    /**
     * 参考方案文件id列表
     */
    private List<Integer> referenceSolutionList;

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

    public List<Integer> getFileIdList() {
        return fileIdList;
    }

    public void setFileIdList(List<Integer> fileIdList) {
        this.fileIdList = fileIdList;
    }

    public List<Integer> getReferenceSolutionList() {
        return referenceSolutionList;
    }

    public void setReferenceSolutionList(List<Integer> referenceSolutionList) {
        this.referenceSolutionList = referenceSolutionList;
    }

    @Override
    public String toString() {
        return "UpdateWorkProjectParam{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", fileIdList=" + fileIdList +
                ", referenceSolutionList=" + referenceSolutionList +
                '}';
    }
}
