package com.hit.curricelumdesign.context.param.teaching;

import com.hit.curricelumdesign.context.param.BaseRequestParam;

import javax.validation.constraints.NotNull;

public class TeachingBaseParam extends BaseRequestParam {

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
