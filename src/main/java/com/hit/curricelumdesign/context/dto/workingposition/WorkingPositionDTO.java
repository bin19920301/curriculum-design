package com.hit.curricelumdesign.context.dto.workingposition;

import com.hit.curricelumdesign.context.dto.workingkstep.WorkingStepDTO;

import java.util.List;

public class WorkingPositionDTO implements Comparable {

    /**
     * 工位id
     */
    private Integer workingPositionId;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 工步集合
     */
    private List<WorkingStepDTO> workingStepList;


    public Integer getWorkingPositionId() {
        return workingPositionId;
    }

    public void setWorkingPositionId(Integer workingPositionId) {
        this.workingPositionId = workingPositionId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public List<WorkingStepDTO> getWorkingStepList() {
        return workingStepList;
    }

    public void setWorkingStepList(List<WorkingStepDTO> workingStepList) {
        this.workingStepList = workingStepList;
    }

    @Override
    public String toString() {
        return "WorkingPositionDTO{" +
                "workingPositionId=" + workingPositionId +
                ", sort=" + sort +
                ", workingStepList=" + workingStepList +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        WorkingPositionDTO dto = (WorkingPositionDTO) o;
        return this.getSort().compareTo(dto.getSort());
    }
}
