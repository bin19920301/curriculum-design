package com.hit.curricelumdesign.context.dto.procedurerules;

public class ProcedureRulesDTO {

    /**
     * id
     */
    private Integer id;

    /**
     * 作业项目id
     */
    private Integer workProjectId;

    /**
     * 规则类型;1加工优先级2加工方法
     */
    private Integer rulesType;

    /**
     * 规则详情
     */
    private String rulesDetails;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWorkProjectId() {
        return workProjectId;
    }

    public void setWorkProjectId(Integer workProjectId) {
        this.workProjectId = workProjectId;
    }

    public Integer getRulesType() {
        return rulesType;
    }

    public void setRulesType(Integer rulesType) {
        this.rulesType = rulesType;
    }

    public String getRulesDetails() {
        return rulesDetails;
    }

    public void setRulesDetails(String rulesDetails) {
        this.rulesDetails = rulesDetails;
    }
}
