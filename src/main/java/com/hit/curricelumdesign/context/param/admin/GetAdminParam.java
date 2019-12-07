package com.hit.curricelumdesign.context.param.admin;

import com.hit.curricelumdesign.context.param.BaseRequestParam;

import javax.validation.constraints.NotNull;

/**
 * @author xbr
 * @Date 2019-12-07
 * @ClassName GetAdminParam
 * @Description
 */
public class GetAdminParam extends BaseRequestParam {

    /**
     * 根据管理员id获取管理员信息
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
        return "GetAdminParam{" +
                "id=" + id +
                '}';
    }
}
