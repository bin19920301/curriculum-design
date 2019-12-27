package com.hit.curricelumdesign.context.param.admin;

import com.hit.curricelumdesign.context.param.BaseRequestParam;

import javax.validation.constraints.NotNull;

/**
 * @author xbr
 * @Date 2019-12-08
 * @ClassName DeleteAdminParam
 * @Description
 */
public class DeleteAdminParam extends BaseRequestParam {
    /**
     * 管理员id
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
        return "DeleteAdminParam{" +
                "id=" + id +
                '}';
    }
}
