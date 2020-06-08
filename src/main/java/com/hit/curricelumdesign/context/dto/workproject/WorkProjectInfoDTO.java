package com.hit.curricelumdesign.context.dto.workproject;

import com.hit.curricelumdesign.context.dto.file.FileDTO;
import com.hit.curricelumdesign.context.dto.file.FileListDTO;

import java.util.List;

/**
 * @author xbr
 * @Date 2019-12-14
 * @ClassName WorkProjectInfoDTO
 * @Description
 */
public class WorkProjectInfoDTO {

    /**
     * 作业项目id
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
     * 文件列表
     */
    private List<FileListDTO> filelist;

    /**
     * 参考方案列表
     */
    private List<FileListDTO> referenceSolutionList;

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

    public List<FileListDTO> getFilelist() {
        return filelist;
    }

    public void setFilelist(List<FileListDTO> filelist) {
        this.filelist = filelist;
    }

    public List<FileListDTO> getReferenceSolutionList() {
        return referenceSolutionList;
    }

    public void setReferenceSolutionList(List<FileListDTO> referenceSolutionList) {
        this.referenceSolutionList = referenceSolutionList;
    }

    @Override
    public String toString() {
        return "WorkProjectInfoDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", filelist=" + filelist +
                ", referenceSolutionList=" + referenceSolutionList +
                '}';
    }
}
