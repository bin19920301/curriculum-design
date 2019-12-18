package com.hit.curricelumdesign.context.param.admin;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author xbr
 * @Date 2019-12-18
 * @ClassName AdminLoginParam
 * @Description
 */
public class AdminLoginParam {


    /**
     * 编号
     */
    @NotNull
    private String number;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AdminLoginParam{" +
                "number='" + number + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
