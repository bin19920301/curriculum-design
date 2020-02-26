package com.hit.curricelumdesign.context.param.processFile;

import com.hit.curricelumdesign.context.param.BaseRequestParam;

import javax.validation.constraints.NotNull;

public class ProcessFileBaseParam extends BaseRequestParam {

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

    @Override
    public String toString() {
        return "FileBaseParam{" +
                "id=" + id +
                '}';
    }
}
