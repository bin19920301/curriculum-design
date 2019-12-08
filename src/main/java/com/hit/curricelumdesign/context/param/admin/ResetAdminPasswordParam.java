package com.hit.curricelumdesign.context.param.admin;

import javax.validation.constraints.NotNull;

/**
 * @author xbr
 * @Date 2019-12-08
 * @ClassName ResetAdminPasswordParam
 * @Description
 */
public class ResetAdminPasswordParam {
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
        return "ResetAdminPasswordParam{" +
                "id=" + id +
                '}';
    }
}
