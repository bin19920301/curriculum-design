package com.hit.curricelumdesign.context.dto.process;

import com.hit.curricelumdesign.context.dto.processfile.ProcessFileDTO;
import com.hit.curricelumdesign.context.dto.workingposition.WorkingPositionDTO;

import java.util.List;
import java.util.Map;

public class ProcessDTO {

    /**
     * 工序id
     */
    private Integer processId;

    /**
     * 工序名称
     */
    private String name;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 加工表面id
     */
    private Integer surfaceId;

    /**
     * 加工表面类型
     */
    private Integer surfaceType;

    /**
     * 加工表面名称
     */
    private String surfaceName;

    /**
     * 工序文件id
     */
    private Integer processFileId;

    /**
     * 工序文件
     */
    private ProcessFileDTO processFile;

    /**
     * 工位集合
     */
    private List<WorkingPositionDTO> workingPositionList;

    //<规则详情>
    private List<String> errorMsg;

    public Integer getProcessId() {
        return processId;
    }

    public void setProcessId(Integer processId) {
        this.processId = processId;
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

    public Integer getSurfaceId() {
        return surfaceId;
    }

    public void setSurfaceId(Integer surfaceId) {
        this.surfaceId = surfaceId;
    }

    public Integer getSurfaceType() {
        return surfaceType;
    }

    public void setSurfaceType(Integer surfaceType) {
        this.surfaceType = surfaceType;
    }

    public String getSurfaceName() {
        return surfaceName;
    }

    public void setSurfaceName(String surfaceName) {
        this.surfaceName = surfaceName;
    }

    public Integer getProcessFileId() {
        return processFileId;
    }

    public void setProcessFileId(Integer processFileId) {
        this.processFileId = processFileId;
    }

    public ProcessFileDTO getProcessFile() {
        return processFile;
    }

    public void setProcessFile(ProcessFileDTO processFile) {
        this.processFile = processFile;
    }

    public List<WorkingPositionDTO> getWorkingPositionList() {
        return workingPositionList;
    }

    public void setWorkingPositionList(List<WorkingPositionDTO> workingPositionList) {
        this.workingPositionList = workingPositionList;
    }

    public List<String> getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(List<String> errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "ProcessDTO{" +
                "processId=" + processId +
                ", name='" + name + '\'' +
                ", sort=" + sort +
                ", surfaceId=" + surfaceId +
                ", surfaceType=" + surfaceType +
                ", surfaceName='" + surfaceName + '\'' +
                ", processFileId=" + processFileId +
                ", processFile=" + processFile +
                ", workingPositionList=" + workingPositionList +
                ", errorMsg=" + errorMsg +
                '}';
    }
}
