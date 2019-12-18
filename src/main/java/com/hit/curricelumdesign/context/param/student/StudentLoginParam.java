package com.hit.curricelumdesign.context.param.student;

import javax.validation.constraints.NotNull;

/**
 * @author xbr
 * @Date 2019-12-15
 * @ClassName StudentLoginParam
 * @Description
 */
public class StudentLoginParam {

    /**
     * 姓名
     */
    @NotNull
    private String name;

    /**
     * 学号
     */
    @NotNull
    private String number;

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
        return "StudentLoginParam{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
