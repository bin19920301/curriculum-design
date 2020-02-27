package com.hit.curricelumdesign.context.dto.process;

import com.hit.curricelumdesign.context.dto.processfile.ProcessFileDTO;
import com.hit.curricelumdesign.context.dto.workingposition.WorkingPositionDTO;

import java.util.List;

public class ProcessDTO {

    /**
     * 工序id
     */
    private Integer id;

    /**
     * 工序名称
     */
    private String name;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 加工表面类型
     */
    private Integer surfaceType;

    /**
     * 加工表面名称
     */
    private String surfaceName;

    /**
     * 工序文件
     */
    private ProcessFileDTO file;

    /**
     * 工位集合
     */
    private List<WorkingPositionDTO> workingPositionDTOList;

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

    public Integer getSort() {
        return sort;
    }

    public Integer getSurfaceType() {
        return surfaceType;
    }

    public void setSurfaceType(Integer surfaceType) {
        this.surfaceType = surfaceType;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }


    public String getSurfaceName() {
        return surfaceName;
    }

    public void setSurfaceName(String surfaceName) {
        this.surfaceName = surfaceName;
    }

    public ProcessFileDTO getFile() {
        return file;
    }

    public void setFile(ProcessFileDTO file) {
        this.file = file;
    }

    public List<WorkingPositionDTO> getWorkingPositionDTOList() {
        return workingPositionDTOList;
    }

    public void setWorkingPositionDTOList(List<WorkingPositionDTO> workingPositionDTOList) {
        this.workingPositionDTOList = workingPositionDTOList;
    }
}
