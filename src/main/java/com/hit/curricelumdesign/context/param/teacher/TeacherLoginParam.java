package com.hit.curricelumdesign.context.param.teacher;

import javax.validation.constraints.NotNull;

/**
 * @author xbr
 * @Date 2019-12-18
 * @ClassName TeacherLoginParam
 * @Description
 */
public class TeacherLoginParam {


    /**
     * 教师编号
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
        return "TeacherLoginParam{" +
                "number='" + number + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
