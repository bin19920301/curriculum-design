package com.hit.curricelumdesign.context.param.procedurerules;

import javax.validation.constraints.NotNull;

public class ProcedureRulesBaseParam {
    /**
     * id
     */
    @NotNull
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
