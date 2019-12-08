package com.hit.curricelumdesign.context.dto.admin;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author xbr
 * @Date 2019-12-08
 * @ClassName AdminDto
 * @Description
 */
public class AdminDTO {
    /**
     * id主键自增非空唯一
     */
    private Integer id;

    /**
     * 管理员登录的密码
     */
    private String password;

    /**
     * 管理员的名称
     */
    private String name;

    /**
     * 管理员的编号
     */
    private String number;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "AdminDTO{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
