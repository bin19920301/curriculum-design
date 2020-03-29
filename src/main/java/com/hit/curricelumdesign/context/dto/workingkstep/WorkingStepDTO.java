package com.hit.curricelumdesign.context.dto.workingkstep;

import com.hit.curricelumdesign.context.dto.errormsg.ErrorMsgDTO;

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
    private String cutDepth;

    /**
     * 主轴转速
     */
    private String mainshaftSpeed;

    /**
     * 夹具或辅助工具
     */
    private String fixture;

    /**
     * 走刀深度
     */
    private String feedingDepth;

    /**
     * 进给量
     */
    private String load;

    /**
     * 切削速度
     */
    private String cutSpeed;

    /**
     * 基本时间
     */
    private String basicTime;

    /**
     * 辅助时间
     */
    private String assistTime;

    /**
     * 工作地服务时间
     */
    private String workspaceServiceTime;

    /**
     * 排序
     */
    private Integer sort;

    private List<ErrorMsgDTO> errorMsg;

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

    public String getCutDepth() {
        return cutDepth;
    }

    public void setCutDepth(String cutDepth) {
        this.cutDepth = cutDepth;
    }

    public String getMainshaftSpeed() {
        return mainshaftSpeed;
    }

    public void setMainshaftSpeed(String mainshaftSpeed) {
        this.mainshaftSpeed = mainshaftSpeed;
    }

    public String getFixture() {
        return fixture;
    }

    public void setFixture(String fixture) {
        this.fixture = fixture;
    }

    public String getFeedingDepth() {
        return feedingDepth;
    }

    public void setFeedingDepth(String feedingDepth) {
        this.feedingDepth = feedingDepth;
    }

    public String getLoad() {
        return load;
    }

    public void setLoad(String load) {
        this.load = load;
    }

    public String getCutSpeed() {
        return cutSpeed;
    }

    public void setCutSpeed(String cutSpeed) {
        this.cutSpeed = cutSpeed;
    }

    public String getBasicTime() {
        return basicTime;
    }

    public void setBasicTime(String basicTime) {
        this.basicTime = basicTime;
    }

    public String getAssistTime() {
        return assistTime;
    }

    public void setAssistTime(String assistTime) {
        this.assistTime = assistTime;
    }

    public String getWorkspaceServiceTime() {
        return workspaceServiceTime;
    }

    public void setWorkspaceServiceTime(String workspaceServiceTime) {
        this.workspaceServiceTime = workspaceServiceTime;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public List<ErrorMsgDTO> getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(List<ErrorMsgDTO> errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "WorkingStepDTO{" +
                "workingStepId=" + workingStepId +
                ", tool=" + tool +
                ", cutter='" + cutter + '\'' +
                ", cutDepth='" + cutDepth + '\'' +
                ", mainshaftSpeed='" + mainshaftSpeed + '\'' +
                ", fixture='" + fixture + '\'' +
                ", feedingDepth='" + feedingDepth + '\'' +
                ", load='" + load + '\'' +
                ", cutSpeed='" + cutSpeed + '\'' +
                ", basicTime='" + basicTime + '\'' +
                ", assistTime='" + assistTime + '\'' +
                ", workspaceServiceTime='" + workspaceServiceTime + '\'' +
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
