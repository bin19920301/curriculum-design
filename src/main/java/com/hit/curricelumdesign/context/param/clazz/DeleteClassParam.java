package com.hit.curricelumdesign.context.param.clazz;

import com.hit.curricelumdesign.context.param.BaseRequestParam;

/**
 * @author xbr
 * @Date 2019-12-09
 * @ClassName DeleteClassParam
 * @Description
 */
public class DeleteClassParam extends BaseRequestParam {

    /**
     * 班级id
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
        return "DeleteClassParam{" +
                "id=" + id +
                '}';
    }
}
