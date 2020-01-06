package com.hit.curricelumdesign.context.bo.work;

import com.hit.curricelumdesign.context.param.BaseRequestParam;

import javax.validation.constraints.NotNull;

public class WorkBaseBO extends BaseRequestParam {

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
        return "WorkBaseBO{" +
                "id=" + id +
                '}';
    }
}
