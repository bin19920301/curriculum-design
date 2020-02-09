package com.hit.curricelumdesign.context.param.card;

import javax.validation.constraints.NotNull;

public class CardBaseParam {
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
