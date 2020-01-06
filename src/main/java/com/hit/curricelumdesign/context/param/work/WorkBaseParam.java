package com.hit.curricelumdesign.context.param.work;

import com.hit.curricelumdesign.context.param.BaseRequestParam;

import javax.validation.constraints.NotNull;

public class WorkBaseParam extends BaseRequestParam {

    /**
     * 作业id
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
        return "WorkBaseParam{" +
                "id=" + id +
                '}';
    }
}
