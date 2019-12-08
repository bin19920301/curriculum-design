package com.hit.curricelumdesign.context.param.admin;

import javax.validation.constraints.NotNull;

/**
 * @author xbr
 * @Date 2019-12-08
 * @ClassName DeleteAdminParam
 * @Description
 */
public class DeleteAdminParam {
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
