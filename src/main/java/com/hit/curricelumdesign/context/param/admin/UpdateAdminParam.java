package com.hit.curricelumdesign.context.param.admin;

import com.hit.curricelumdesign.context.param.BaseRequestParam;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author xbr
 * @Date 2019-12-08
 * @ClassName UpdateAdminParam
 * @Description
 */
public class UpdateAdminParam extends BaseRequestParam {

    /**
     * 管理员编号
     */
    private Integer id;

    /**
     * 编号
     */
    @NotNull
    @Size(min = 0, max = 30, message = "编号")
    private String number;

    /**
     * 姓名
     */
    @NotNull
    @Size(min = 0, max = 30, message = "姓名")
    private String name;

    /**
     * 密码
     */
    @NotNull
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
        return "UpdateAdminParam{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
