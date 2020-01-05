package com.hit.curricelumdesign.context.param.TeacherMessage;

import com.hit.curricelumdesign.context.param.BaseRequestParam;

/**
 * @author xbr
 * @Date 2019-12-22
 * @ClassName WorkMessageBaseParam
 * @Description
 */
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
