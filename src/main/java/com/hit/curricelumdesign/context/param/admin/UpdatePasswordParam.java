package com.hit.curricelumdesign.context.param.admin;

import com.hit.curricelumdesign.context.param.BaseRequestParam;

import javax.validation.constraints.NotNull;

public class UpdatePasswordParam extends BaseRequestParam {
    /**
     * 管理员编号
     */
    @NotNull
    private Integer id;


    /**
     * 旧密码
     */
    @NotNull
    @NotNull
    private String oldPassword;

    /**
     * 新密码
     */
    @NotNull
    private String newPassword;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    @Override
    public String toString() {
        return "UpdatePasswordParam{" +
                "id=" + id +
                ", oldPassword='" + oldPassword + '\'' +
                ", newPassword='" + newPassword + '\'' +
                '}';
    }
}
