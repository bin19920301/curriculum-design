package com.hit.curricelumdesign.context.param.procedurerules;

import com.hit.curricelumdesign.context.param.BaseRequestParam;

import javax.validation.constraints.NotEmpty;

public class AddProcedureRulesParam extends BaseRequestParam {

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
    @NotEmpty
    private String rulesDetails;

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
