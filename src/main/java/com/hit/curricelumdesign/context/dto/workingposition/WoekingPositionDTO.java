package com.hit.curricelumdesign.context.dto.workingposition;

import com.hit.curricelumdesign.context.dto.workingkstep.WorkingStepDTO;

import java.util.List;

public class WoekingPositionDTO {

    /**
     * 工位id
     */
    private Integer id;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 工布集合
     */
    private List<WorkingStepDTO> workingStepDTOList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public List<WorkingStepDTO> getWorkingStepDTOList() {
        return workingStepDTOList;
    }

    public void setWorkingStepDTOList(List<WorkingStepDTO> workingStepDTOList) {
        this.workingStepDTOList = workingStepDTOList;
    }
}
