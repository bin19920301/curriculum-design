package com.hit.curricelumdesign.context.param.admin;

import javax.validation.constraints.NotNull;

/**
 * @author xbr
 * @Date 2019-12-08
 * @ClassName AddAdminParam
 * @Description
 */
public class AddAdminParam {
    /**
     * 编号
     */
    @NotNull
    private String number;

    /**
     * 姓名
     */
    @NotNull
    private String name;

    /**
     * 密码
     */
    @NotNull
    private String password;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AddAdminParam{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
