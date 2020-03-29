package com.hit.curricelumdesign.context.dto.workingkstep;

import java.util.List;

public class WorkingStepDTO implements Comparable {

    /**
     * 工步id
     */
    private Integer workingStepId;

    /**
     * 机床;1车床,2铣床,3刨床,4磨床,5钻床,6铰床
     */
    private Integer tool;

    /**
     * 刀具
     */
    private String cutter;

    /**
     * 切削深度
     */
    private Integer cutDepth;

    /**
     * 主轴转速
     */
    private Integer mainshaftSpeed;

    /**
     * 夹具或辅助工具
     */
    private String fixture;

    /**
     * 走刀深度
     */
    private Integer feedingDepth;

    /**
     * 进给量
     */
    private Integer load;

    /**
     * 切削速度
     */
    private Integer cutSpeed;

    /**
     * 基本时间
     */
    private Integer basicTime;

    /**
     * 辅助时间
     */
    private Integer assistTime;

    /**
     * 工作地服务时间
     */
    private Integer workspaceServiceTime;

    /**
     * 排序
     */
    private Integer sort;

    //<规则详情>
    private List<String> errorMsg;

    public Integer getWorkingStepId() {
        return workingStepId;
    }

    public void setWorkingStepId(Integer workingStepId) {
        this.workingStepId = workingStepId;
    }

    public Integer getTool() {
        return tool;
    }

    public void setTool(Integer tool) {
        this.tool = tool;
    }

    public String getCutter() {
        return cutter;
    }

    public void setCutter(String cutter) {
        this.cutter = cutter;
    }

    public Integer getCutDepth() {
        return cutDepth;
    }

    public void setCutDepth(Integer cutDepth) {
        this.cutDepth = cutDepth;
    }

    public Integer getMainshaftSpeed() {
        return mainshaftSpeed;
    }

    public void setMainshaftSpeed(Integer mainshaftSpeed) {
        this.mainshaftSpeed = mainshaftSpeed;
    }

    public String getFixture() {
        return fixture;
    }

    public void setFixture(String fixture) {
        this.fixture = fixture;
    }

    public Integer getFeedingDepth() {
        return feedingDepth;
    }

    public void setFeedingDepth(Integer feedingDepth) {
        this.feedingDepth = feedingDepth;
    }

    public Integer getLoad() {
        return load;
    }

    public void setLoad(Integer load) {
        this.load = load;
    }

    public Integer getCutSpeed() {
        return cutSpeed;
    }

    public void setCutSpeed(Integer cutSpeed) {
        this.cutSpeed = cutSpeed;
    }

    public Integer getBasicTime() {
        return basicTime;
    }

    public void setBasicTime(Integer basicTime) {
        this.basicTime = basicTime;
    }

    public Integer getAssistTime() {
        return assistTime;
    }

    public void setAssistTime(Integer assistTime) {
        this.assistTime = assistTime;
    }

    public Integer getWorkspaceServiceTime() {
        return workspaceServiceTime;
    }

    public void setWorkspaceServiceTime(Integer workspaceServiceTime) {
        this.workspaceServiceTime = workspaceServiceTime;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public List<String> getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(List<String> errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "WorkingStepDTO{" +
                "workingStepId=" + workingStepId +
                ", tool=" + tool +
                ", cutter='" + cutter + '\'' +
                ", cutDepth=" + cutDepth +
                ", mainshaftSpeed=" + mainshaftSpeed +
                ", fixture='" + fixture + '\'' +
                ", feedingDepth=" + feedingDepth +
                ", load=" + load +
                ", cutSpeed=" + cutSpeed +
                ", basicTime=" + basicTime +
                ", assistTime=" + assistTime +
                ", workspaceServiceTime=" + workspaceServiceTime +
                ", sort=" + sort +
                ", errorMsg=" + errorMsg +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        WorkingStepDTO dto = (WorkingStepDTO) o;
        return this.getSort().compareTo(dto.getSort());

    }
}
