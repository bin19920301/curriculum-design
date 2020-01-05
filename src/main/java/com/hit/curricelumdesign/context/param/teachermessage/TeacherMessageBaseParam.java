package com.hit.curricelumdesign.context.param.teachermessage;

import com.hit.curricelumdesign.context.param.BaseRequestParam;

public class TeacherMessageBaseParam extends BaseRequestParam {

    /**
     * 消息id
     */
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "WorkMessageBaseParam{" +
                "id=" + id +
                '}';
    }
}
