package com.hit.curricelumdesign.context.param.procedurerules;

import com.hit.curricelumdesign.context.param.BaseListRequestParam;

import javax.validation.constraints.NotNull;

public class ListProcedureRulesByProjectIdParam extends BaseListRequestParam {

    /**
     * 作业项目id
     */
    @NotNull
    private Integer projectId;

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
}
