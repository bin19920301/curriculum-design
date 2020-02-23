package com.hit.curricelumdesign.context.param.work;

import java.util.List;

/**
 * @author xbr
 * @Date 2020-02-15
 * @ClassName WorkingPositionParam
 * @Description
 */
public class WorkingPositionParam {

    /**
     * 工位id
     */
    private Integer workingPositionId;

    /**
     * 工位列表
     */
    private List<WorkingStepParam> workingStepList;

    /**
     * 排序
     */
    private Integer sort;

    public Integer getWorkingPositionId() {
        return workingPositionId;
    }

    public void setWorkingPositionId(Integer workingPositionId) {
        this.workingPositionId = workingPositionId;
    }

    public List<WorkingStepParam> getWorkingStepList() {
        return workingStepList;
    }

    public void setWorkingStepList(List<WorkingStepParam> workingStepList) {
        this.workingStepList = workingStepList;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "WorkingPositionParam{" +
                "workingPositionId=" + workingPositionId +
                ", workingStepList=" + workingStepList +
                ", sort=" + sort +
                '}';
    }
}
