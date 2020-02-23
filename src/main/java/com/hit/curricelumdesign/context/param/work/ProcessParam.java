package com.hit.curricelumdesign.context.param.work;

import javax.persistence.Column;
import java.util.List;

/**
 * @author xbr
 * @Date 2020-02-15
 * @ClassName ProcessParam
 * @Description
 */
public class ProcessParam {

    /**
     * 工序id
     */
    private Integer processId;

    /**
     * 加工表面id
     */
    private Integer surfaceId;

    /**
     * 工序文件id
     */
    private Integer processFileId;

    /**
     * 工序名称
     */
    private String name;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 工位列表
     */
    private List<WorkingPositionParam> workingPositionList;

    public Integer getProcessId() {
        return processId;
    }

    public void setProcessId(Integer processId) {
        this.processId = processId;
    }

    public Integer getSurfaceId() {
        return surfaceId;
    }

    public void setSurfaceId(Integer surfaceId) {
        this.surfaceId = surfaceId;
    }

    public Integer getProcessFileId() {
        return processFileId;
    }

    public void setProcessFileId(Integer processFileId) {
        this.processFileId = processFileId;
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

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public List<WorkingPositionParam> getWorkingPositionList() {
        return workingPositionList;
    }

    public void setWorkingPositionList(List<WorkingPositionParam> workingPositionList) {
        this.workingPositionList = workingPositionList;
    }

    @Override
    public String toString() {
        return "ProcessParam{" +
                "processId=" + processId +
                ", surfaceId=" + surfaceId +
                ", processFileId=" + processFileId +
                ", name='" + name + '\'' +
                ", sort=" + sort +
                ", workingPositionList=" + workingPositionList +
                '}';
    }
}
