package com.hit.curricelumdesign.context.param.file;

import javax.validation.constraints.NotNull;

public class FileBaseParam {

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
