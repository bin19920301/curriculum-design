package com.hit.curricelumdesign.context.param.teaching;

import javax.validation.constraints.NotNull;

public class TeachingBaseParam {

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
