package com.hit.curricelumdesign.context.param.procedurerules;

import javax.validation.constraints.NotNull;

public class UpdateProcedureRulesParam extends ProcedureRulesBaseParam {

    /**
     * 规则类型;1加工优先级2加工方法
     */
    @NotNull
    private Integer rulesType;

    /**
     * 规则详情
     */

    @NotNull
    private String rulesDetails;

    /**
     * 作业项目id
     */
    @NotNull
    private Integer workProjectId;

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
